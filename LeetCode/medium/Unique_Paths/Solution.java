package medium.Unique_Paths;

/**
 * Runtime : 1ms(27.12%)
 * Memory : 38.3mb(5.09%)
 */
public class Solution {
    public int uniquePaths(int height, int width) {
        int[][] record = new int[height][width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(y == 0 || x == 0) record[y][x] = 1;
                else record[y][x] = record[y - 1][x] + record[y][x - 1];
            }
        }

        return record[height - 1][width - 1];
    }
}
