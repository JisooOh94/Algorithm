package medium.Score_After_Flipping_Matrix;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Runtime : 8ms
 * Memory : 39.5mb
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[][] param = new int[][]{
//                {0,0,1,1},
//                {1,0,1,0},
//                {1,1,0,0}
//        };
        int[][] param = new int[][]{
                {0},
                {1}
        };

        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return matrixScore((int[][])params[0]);
    }

    private static final Pattern PATTERN = Pattern.compile("\\[|\\]|,|\\s");
    public void colRecursion(int[][] board) {
        //column chk
        for (int x = 0; x < board[0].length; x++) {
            int plusCnt = 0;
            for (int y = 0; y < board.length; y++) {
                plusCnt += board[y][x] == 0 ? 1 : -1;
            }
            if (plusCnt > 0) {
                for (int y = 0; y < board.length; y++) {
                    board[y][x] = board[y][x] == 0 ? 1 : 0;
                }
            }
        }
        rowRecursion(board);
    }

    public void rowRecursion(int[][] board) {
        boolean modified = false;
        //row chk
        for(int y = 0; y < board.length; y++) {
            if(board[y][0] == 0) {
                modified = true;
                for(int x = 0; x < board[y].length; x++) {
                    board[y][x] = board[y][x] == 0 ? 1 : 0;
                }
            }
        }
        if(modified) colRecursion(board);
    }
    public int matrixScore(int[][] A) {
        colRecursion(A);
        int result = 0;
        for(int[] arr : A) {
            result += Integer.parseInt(PATTERN.matcher(Arrays.toString(arr)).replaceAll(""), 2);
        }

        return result;
    }
}
