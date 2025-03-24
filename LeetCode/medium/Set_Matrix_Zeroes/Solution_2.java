package medium.Set_Matrix_Zeroes;

/**
 * Time Complexity : O(n)
     * 1 ms Beats 74.09%
 * Space Complexity : O(1)
    * 46.19 MB Beats 6.13%
 */
public class Solution_2 {
    public void setZeroes(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;

        boolean isRowNeedToUdpateZero = false;
        boolean isColNeedToUdpateZero = false;
        for (int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if (matrix[y][x] == 0) {
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;

                    if (y == 0) {
                        isRowNeedToUdpateZero = true;
                    }

                    if (x == 0) {
                        isColNeedToUdpateZero = true;
                    }
                }
            }
        }

        for (int y = 1; y < height; y++) {
            for(int x = 1; x < width; x++) {
                if (matrix[y][0] == 0 || matrix[0][x] == 0) {
                    matrix[y][x] = 0;
                }
            }
        }

        if (isRowNeedToUdpateZero) {
            for (int x = 0; x < width; x++) {
                matrix[0][x] = 0;
            }
        }

        if (isColNeedToUdpateZero) {
            for (int y = 0; y < height; y++) {
                matrix[y][0] = 0;
            }
        }
    }
}
