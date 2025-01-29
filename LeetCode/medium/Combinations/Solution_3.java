package medium.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Time Complexity :
 * 13ms Beats 98.98%
 * 94.80MB Beats 21.61%
 */
public class Solution_3 {
    @Test
    public void execute() {
        List<List<Integer>> result = combine(4, 2);
        for(List<Integer> list : result) {
            list.forEach(num -> System.out.print(num + ","));
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recurion(1, n, k, result, new ArrayList<>(k));
        return result;
    }

    private void recurion(int fromNum, int toNum, int numberCnt, List<List<Integer>> result, List<Integer> numbers) {
        if (numberCnt == 0) {
            result.add(new ArrayList<>(numbers));
            return;
        }

        for (int i = fromNum; i <= toNum - numberCnt + 1; i++) {
            numbers.add(i);
            recurion(i + 1, toNum, numberCnt - 1, result, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}
