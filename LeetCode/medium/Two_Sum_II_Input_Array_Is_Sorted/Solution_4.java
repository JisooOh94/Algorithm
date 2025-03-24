package medium.Two_Sum_II_Input_Array_Is_Sorted;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity : O(n)
    * 3 ms Beats 25.13%
 * Space Complexity : O(1)
    * 46.68 MB Beats 93.31%
 */
public class Solution_4 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        Integer[] record = new Integer[2001];

        for (int i = 0; i < numbers.length; i++) {
            int needNum = target - numbers[i];
            if (needNum < -1000 || 1000 < needNum) {
                continue;
            }

            Integer needNumIdx = record[needNum + 1000];
            if (needNumIdx != null) {
                return new int[]{needNumIdx + 1, i + 1};
            }

            record[numbers[i] + 1000] = i;
        }

        return null;
    }
}
