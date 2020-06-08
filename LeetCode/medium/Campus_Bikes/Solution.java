package medium.Campus_Bikes;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Garbage
 */
public class Solution implements Predicate<int[], Object> {
    @Test
    public void execute() {
        int[][] workers = new int[][]{{0,0},{1,1},{2,0}};
        int[][] bikes = new int[][]{{1,0},{2,2},{2,1}};

        PerformanceUtil.calcPerformance(new Solution(), workers, bikes);
    }

    @Override
    public int[] test(Object... params) {
        int[] result = assignBikes((int[][]) params[0], (int[][]) params[1]);
        for (int elem : result) {
            System.out.print(elem + " ");
        }
        return result;
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int length = bikes.length;
        int[][] distFromBikeToUser = new int[length][bikes.length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                distFromBikeToUser[i][j] = Math.abs(bikes[i][0] - workers[j][0]) + Math.abs(bikes[i][1] - workers[j][1]);
            }
        }

        List<Integer> userList = IntStream.range(0, length).boxed().collect(Collectors.toCollection(LinkedList::new));
        int resultArr[] = new int[length];

        for (int bikeIdx = 0; bikeIdx < length; bikeIdx++) {
            int min = 9999;
            int minUserIdx = 0;
            for (int userIdx : userList) {
                if (distFromBikeToUser[bikeIdx][userIdx] < min) {
                    min = distFromBikeToUser[bikeIdx][userIdx];
                    minUserIdx = userIdx;
                }
            }
            resultArr[bikeIdx] = minUserIdx;
            userList.remove((Object) minUserIdx);
        }

        return resultArr;
    }
}
