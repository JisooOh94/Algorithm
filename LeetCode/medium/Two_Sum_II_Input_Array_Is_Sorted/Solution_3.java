package medium.Two_Sum_II_Input_Array_Is_Sorted;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity : O(n)
    * 6 ms Beats 15.78%
 * Space Complexity : O(1)
    * 46.40 MB Beats 97.02%
 */
public class Solution_3 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        Map<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int needNum = target - numbers[i];
            Integer needNumIdx = record.get(needNum);
            if (needNumIdx != null) {
                return new int[]{needNumIdx + 1, i + 1};
            }

            record.put(numbers[i], i);
        }

        return null;
    }
}
