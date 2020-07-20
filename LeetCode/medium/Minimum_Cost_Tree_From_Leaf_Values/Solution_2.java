package medium.Minimum_Cost_Tree_From_Leaf_Values;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 6ms(26.79%)
 * Memory : 37.3mb(48.59%)
 */
public class Solution_2 {
    @Test
    public void execute() {
        //int[] arr = new int[]{6, 2, 4, 8};
        int[] arr = new int[]{1,10,11,8,12,14,1,15,3,11,6,12};
        System.out.println(mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {
        int[][] record = new int[arr.length][arr.length];
        return recursion(0, arr.length - 1, arr, record);
    }

    private int recursion(int startIdx, int endIdx, int[] arr, int[][] record) {
        if(startIdx >= endIdx) return 0;
        else if(record[startIdx][endIdx] != 0) return record[startIdx][endIdx];
        int minSum = 9999999;

        for(int i = startIdx; i < endIdx; i++) {
            int leftMin = recursion(startIdx, i, arr, record);
            int rightMin = recursion(i + 1, endIdx, arr, record);

            int leftMax = -1;
            for(int j = startIdx; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            int rightMax = -1;
            for(int j = i + 1; j <= endIdx; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            int sum = leftMax * rightMax + leftMin + rightMin;
            minSum = Math.min(minSum, sum);
        }
        record[startIdx][endIdx] = minSum;
        return minSum;
    }
}
