package medium.Score_After_Flipping_Matrix;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.2mb(100.00%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
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

    public int matrixScore(int[][] board) {
        for(int y = 0; y < board.length; y++) {
            if(board[y][0] == 0) {
                for(int x = 0; x < board[y].length; x++) {
                    board[y][x] = board[y][x] == 0 ? 1 : 0;
                }
            }
        }

        int sum = 0;

        for (int x = 0; x < board[0].length; x++) {
            int zeroCnt = 0;
            for (int y = 0; y < board.length; y++) {
                if(board[y][x] == 0) zeroCnt++;
            }
            int oneCnt = board.length - zeroCnt;
            sum += (zeroCnt > oneCnt ? zeroCnt : oneCnt) * Math.pow(2, board[0].length - x - 1);
        }
        return sum;
    }
}
