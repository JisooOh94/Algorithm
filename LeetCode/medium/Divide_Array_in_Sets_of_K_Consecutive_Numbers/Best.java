package medium.Divide_Array_in_Sets_of_K_Consecutive_Numbers;

import util.Predicate;

import java.util.*;


public class Best implements Predicate<Boolean, Object> {
    @Override
    public Boolean test(Object... params) {
        return isPossibleDivide((int[]) params[0], (int) params[1]);
    }

    private class Pair {
        int val;
        int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return false;

        Arrays.sort(nums);
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < nums.length; ) {
            int val = nums[i];
            int j = i;
            while (j < n && nums[j] == val) j++;
            Pair pair = new Pair(val, j - i);
            list.add(pair);
            i = j;
        }

        if (list.size() < k) return false;
        //start to make sets
        int m = list.size();
        for (int i = 0; i < m; i++) {
            Pair p = list.get(i);
            int val = p.val;
            int count = p.count;
            if (count == 0) continue; //no need to start new sets
            //cannot make sets any more but still have numbers
            if (i > m - k && count > 0) return false;
            for (int j = i + 1; j < i + k; j++) {
                Pair p1 = list.get(j);
                int val1 = p1.val;
                if (val1 != val + j - i) return false;
                int count1 = p1.count;
                count1 -= count;
                if (count1 < 0) return false;
                p1.count = count1;
                list.set(j, p1);
            }
        }
        return true;
    }
}
