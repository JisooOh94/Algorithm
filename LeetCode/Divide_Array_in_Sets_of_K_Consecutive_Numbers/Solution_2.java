package Divide_Array_in_Sets_of_K_Consecutive_Numbers;

import util.Predicate;

import java.util.Arrays;
import java.util.LinkedList;

//Failed
public class Solution_2 implements Predicate<Boolean, Object> {
    @Override
    public Boolean test(Object... params) {
        return isPossibleDivide((int[]) params[0], (int) params[1]);
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);

        int[] countArr = new int[nums[nums.length - 1]];

        for(int num : nums) countArr[num - 1]++;

        int startIdx = 0;
        while(startIdx <= countArr.length - k) {
            int targetCnt = countArr[startIdx];
            countArr[startIdx] = 0;

            int nextStartIdx = -1;
            for(int i = startIdx + 1; i < startIdx + k; i++) {
                if(countArr[i] < targetCnt) return false;
                else if(countArr[i] > targetCnt && nextStartIdx == -1) nextStartIdx = i;
                countArr[i] -= targetCnt;
            }

            if(nextStartIdx == -1) nextStartIdx = startIdx + k;
            startIdx = nextStartIdx;
        }

        if(countArr[countArr.length - 1] != 0) return false;

        return true;
    }
}
