package medium.Matrix_Block_Sum;

import org.junit.Test;

/**
 * Runtime : 596ms
 * Memory : 46.4mb
 */
public class Solution {
    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] sum = new int[9];
        int k = 3;

        for(int i = 0; i < 9; i++) {
            for(int j = Math.max(i - k, 0); j <= Math.min(i + k, 8); j++) {
                sum[i] += arr[j];
            }
        }

        for(int num : sum) {
            System.out.println(num);
        }

        int[] sum_2 = new int[9];
        for(int i = 0; i <= k; i++)
            sum_2[0] += arr[i];

        for(int i = 1; i < 9; i++) {
            sum_2[i] = sum_2[i - 1];
            if(i - k > 0)
                sum_2[i] -= arr[i - k - 1];
            if(i + k < 9)
                sum_2[i] += arr[i + k];
        }

        System.out.println();
        for(int num : sum_2) {
            System.out.println(num);
        }
    }

    @Test
    public void test_2() {
        int k = 3;
        int[][] arr = new int[][]{{1,2,3,4,5}, {5,4,3,2,1}, {1,2,3,4,5}, {5,4,3,2,1}, {1,2,3,4,5}};
        int[][] sum = new int[5][5];

        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                for(int i = Math.max(y - k, 0); i <= Math.min(y + k, 4); i++) {
                    for(int j = Math.max(x - k, 0); j <= Math.min(x + k, 4); j++) {
                        sum[y][x] += arr[i][j];
                    }
                }
            }
        }

        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                System.out.print(sum[y][x] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void execute() {
        int[][] arr = new int[][]{{1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}};
        int k = 3;

        matrixBlockSum(arr, k);
    }

    public int[][] matrixBlockSum(int[][] arr, int k) {
        int[][] sum = new int[arr.length][arr[0].length];

        for(int y = 0; y < arr.length; y++) {
            for(int x = 0; x < arr[0].length; x++) {
                for(int i = Math.max(y - k, 0); i <= Math.min(y + k, arr.length - 1); i++) {
                    for(int j = Math.max(x - k, 0); j <= Math.min(x + k, arr[0].length - 1); j++) {
                        sum[y][x] += arr[i][j];
                    }
                }
            }
        }

        return sum;
    }
}
