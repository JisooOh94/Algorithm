package easy.Merge_Sorted_Array;

import org.junit.Test;

/**
 * Subject : Array
 * Time Complexity : O(m+n)
     * 0ms(Beats 100.00%)
 * Space Complexity : O(1)
     * 42.18MB(Beats 60.68%)
 */
public class Solution_4 {
    @Test
    public void execute() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        int a = 0;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int num1Pos = m - 1;
        int num2Pos = n - 1;
        int resultPos = m + n - 1;

        while (0 <= num1Pos || 0 <= num2Pos) {
            if (num1Pos == -1) {
                nums1[resultPos--] = nums2[num2Pos--];
            } else if (num2Pos == -1) {
                nums1[resultPos--] = nums1[num1Pos--];
            } else {
                if (nums1[num1Pos] > nums2[num2Pos]) {
                    nums1[resultPos--] = nums1[num1Pos--];
                } else {
                    nums1[resultPos--] = nums2[num2Pos--];
                }
            }
        }
    }
}
