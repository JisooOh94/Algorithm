package medium.Combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sun.awt.image.ImageWatched.Link;

/**
 * 23ms Beats 25.17%
 * 147.63MB Beats 5.01%
 */
public class Solution_2 {
    @Test
    public void execute() {
        List<List<Integer>> result = combine(4, 2);
        for(List<Integer> list : result) {
            list.forEach(num -> System.out.print(num + ","));
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        recurion(1, n, k, result, new LinkedList<>());
        return result;
    }

    private void recurion(int fromNum, int toNum, int numberCnt, List<List<Integer>> result, LinkedList<Integer> numbers) {
        if (numberCnt == 0) {
            result.add(new LinkedList<>(numbers));
            return;
        }

        for (int i = fromNum; i <= toNum - numberCnt + 1; i++) {
            numbers.addLast(i);
            recurion(i + 1, toNum, numberCnt - 1, result, numbers);
            numbers.removeLast();
        }
    }
}
