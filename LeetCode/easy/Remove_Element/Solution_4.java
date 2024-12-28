package easy.Remove_Element;

/**
 * Time Complexity : O(n)
    * 0 ms Beats 100.00%
 * Space Complexity : O(1)
    * 42.15 MB Beats 20.43%
 */
public class Solution_4 {
    public int removeElement(int[] nums, int val) {
        int frontIdx = 0;
        int rearIdx = nums.length - 1;

        while(true) {
            if (frontIdx == nums.length) {
                break;
            }

            if (nums[frontIdx] == val) {
                while (true) {
                    if (nums[rearIdx] != val) {
                        int temp = nums[rearIdx];
                        nums[rearIdx] = nums[frontIdx];
                        nums[frontIdx] = temp;
                        break;
                    }

                    if (frontIdx == rearIdx) {
                        return frontIdx;
                    }

                    rearIdx--;
                }
            }
            frontIdx++;
        }
        return nums.length;
    }
}
