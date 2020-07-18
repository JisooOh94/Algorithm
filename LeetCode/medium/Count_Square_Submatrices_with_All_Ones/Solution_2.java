package medium.Count_Square_Submatrices_with_All_Ones;

import org.junit.Test;

/**
 * Runtime : 5ms(97.47%%)
 * Memory : 51.9mb(66.12%)
 */
public class Solution_2 {
    @Test
    public void execute() {
        //int[][] matrix = new int[][]{{0, 1, 1, 1},{1, 1, 1, 1},{0, 1, 1, 1}};
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}};
        System.out.println(countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int squareCnt = 0;
        int[][] record = new int[matrix.length + 1][matrix[0].length + 1];
        for(int y = 0; y < matrix.length; y++) {
            for(int x = 0; x < matrix[0].length; x++) {
                if(matrix[y][x] == 1) {
                    record[y + 1][x + 1] = Math.min(Math.min(record[y][x + 1], record[y + 1][x]), record[y][x]) + 1;
                    squareCnt += record[y + 1][x + 1];
                }
            }
        }
        return squareCnt;
    }
}
