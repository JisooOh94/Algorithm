package medium.Combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 86ms Beats 5.00%
 * 150.38MB Beats 5.01%
 */
public class Solution_1 {
    @Test
    public void execute() {
        List<List<Integer>> result = combine(1, 1);
        for(List<Integer> list : result) {
            list.forEach(num -> System.out.print(num + ","));
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        return recurion(1, n, k);
    }

    private List<List<Integer>> recurion(int fromNum, int toNum, int numberCnt) {
        if (numberCnt == 0) {
            return new LinkedList<>(Arrays.asList());
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = fromNum; i <= toNum - numberCnt + 1; i++) {
            List<List<Integer>> childResult = recurion(i + 1, toNum, numberCnt - 1);
            if (childResult.isEmpty()) {
                childResult.add(new LinkedList<>(Arrays.asList(i)));
            } else {
                for (List<Integer> list : childResult) {
                    list.add(i);
                }
            }
            result.addAll(childResult);
        }

        return result;
    }
}
