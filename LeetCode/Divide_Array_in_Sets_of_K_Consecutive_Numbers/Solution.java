package Divide_Array_in_Sets_of_K_Consecutive_Numbers;

import util.Predicate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution implements Predicate<Boolean, Object> {
    @Override
    public Boolean test(Object... params) {
        return isPossibleDivide((int[]) params[0], (int) params[1]);
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int num : nums) list.add(num);

        while(!list.isEmpty()) {
            int num = list.removeFirst();
            for(int i = 1; i < k; i++) {
                if(!list.remove((Object)(num + i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
