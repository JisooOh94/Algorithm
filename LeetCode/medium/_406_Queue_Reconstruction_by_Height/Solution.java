package medium._406_Queue_Reconstruction_by_Height;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Runtime : 11ms(34.23%)
 * Memory : 40.3mb(97.87%)
 */
public class Solution implements Predicate<int[][], Object> {
    @Test
    public void execute() {
//        int[][] param = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] param = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
}

    @Override
    public int[][] test(Object... params) {
        int[][] result = reconstructQueue((int[][])params[0]);
        for(int[] elem : result) {
            System.out.print(elem[0] + ", " + elem[1] + " - ");
        }
        return result;
    }

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];
        else if(people.length == 1) return people;
        int[][] resutArr = new int[people.length][people[0].length];

        Arrays.sort(people, (e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);

        List<Integer> idxList = IntStream.range(0, people.length).boxed().collect(Collectors.toCollection(LinkedList::new));

        int prev = people[0][0];
        int prevRemoved = 0;
        for(int i = 0; i < people.length; i++) {
            int cur = people[i][0];
            if(cur != prev) {
                prev = cur;
                prevRemoved = 0;
            }

            int idx = idxList.get(people[i][1] - prevRemoved);

            resutArr[idx] = people[i];
            idxList.remove(people[i][1] - prevRemoved);
            prevRemoved++;
        }

        return resutArr;
    }
}
