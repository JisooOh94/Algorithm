package medium.Split_Array_into_Consecutive_Subsequences;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    @Test
    public void test() {
//        int[] nums = new int[]{1,2,3,3,4,5};
        int[] nums = new int[]{1,2,3,4,4,5};
        /*int[] nums = new int[]{1,2,3,3,4,4,5,5};*/
        System.out.print(isPossible(nums));
    }

    public boolean isPossible(int[] nums) {
        List<int[]> consecCntList = new LinkedList<>();

        int numCnt = 0;
        int prev = nums[0];

        for(int idx = 0; idx <= nums.length; idx++) {
            int num = idx == nums.length ? prev + 1 : nums[idx];
            if(num != prev) {
                if(numCnt < consecCntList.size()) {
                    int removeCnt = consecCntList.size() - numCnt;
                    for(Iterator<int[]> iter = consecCntList.iterator(); iter.hasNext();) {
                        if(iter.next()[0] >= 3) iter.remove();
                        else return false;
                        if(--removeCnt == 0) break;
                    }
                }

                numCnt -= consecCntList.size();
                for(Iterator<int[]> iter = consecCntList.iterator(); iter.hasNext();) {
                    int[] left = iter.next();
                    left[0] += 1;
                }

                for(int i = 0; i < numCnt; i++)
                    consecCntList.add(new int[]{1});

                prev = num;
                numCnt = 0;
            }

            numCnt++;
        }

        return ((LinkedList<int[]>) consecCntList).getLast()[0] < 3 ? false : true;
    }
}
