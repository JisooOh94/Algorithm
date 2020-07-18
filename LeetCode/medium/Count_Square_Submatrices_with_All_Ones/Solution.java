package medium.Count_Square_Submatrices_with_All_Ones;

import org.junit.Test;

/**
 * Runtime : 10ms(31.31%)
 * Memory : 48.7mb(88.84%)
 */
public class Solution {
    @Test
    public void execute() {
        //int[][] matrix = new int[][]{{0, 1, 1, 1},{1, 1, 1, 1},{0, 1, 1, 1}};
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}};
        System.out.println(countSquares(matrix));
    }

    boolean chkSquare(int startX, int startY, int length, int[][] matrix) {
        int endX = startX + length;
        int endY = startY + length;

        if (endX == matrix[0].length || endY == matrix.length) return false;

        for (int i = 0; i <= length; i++)
            if (matrix[endY][startX + i] != 1 || matrix[startY + i][endX] != 1) return false;

        return true;
    }

    public int countSquares(int[][] matrix) {
        int squareCnt = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    int length = 0;
                    while (chkSquare(x, y, length++, matrix)) {
                        squareCnt++;
                    }
                }
            }
        }
        return squareCnt;
    }
}
