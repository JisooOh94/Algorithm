package medium.Number_of_Distinct_Islands;

import util.Predicate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Runtime : 9ms(51.98%)
 * Memory : 40.6mb(100.00%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Override
    public Integer test(Object... params) {
        return numDistinctIslands((int[][])params[0]);
    }

    private static final int LAND = 1;

    private int[][] direction = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };


    public void recursion(int y, int x, int from, int height, int width, List<Integer> dirList, int[][] grid, boolean[][] visited) {
        for(int i = 0; i < 4; i++) {
            int newY = y + direction[i][0];
            int newX = x + direction[i][1];

            if(0 <= newY && newY < height && 0 <= newX && newX < width && grid[newY][newX] == LAND && !visited[newY][newX]) {
                visited[newY][newX] = true;
                dirList.add(from);
                dirList.add(i);

                recursion(newY, newX, i, height, width, dirList, grid, visited);
            }
        }
    }


    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        else if(grid.length == 1 && grid[0].length  == 1) return grid[0][0] == LAND ? 1 : 0;

        int height = grid.length;
        int width = grid[0].length;
        Set<List<Integer>> distinctLandSet = new HashSet<>();

        boolean[][] visited = new boolean[height][width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(grid[y][x] == LAND && !visited[y][x]) {
                    visited[y][x] = true;
                    List<Integer> dirList = new LinkedList<>();
                    dirList.add(4);

                    recursion(y, x, 4, height, width, dirList, grid, visited);
                    distinctLandSet.add(dirList);
                }
            }
        }

        return distinctLandSet.size();
    }
}
