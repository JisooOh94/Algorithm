package easy.Merge_Sorted_Array;

import org.junit.Test;

/**
 * Subject : Array
 * Time Complexity : O(m+n)
     * 0ms(Beats 100.00%)
 * Space Complexity : O(m)
     * 42.29MB(Beats 44.17%)
 */
public class Solution_1 {
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

        int[] num1Cpy = new int[m];
        for (int i = 0; i < m; i++) {
            num1Cpy[i] = nums1[i];
        }

        int num1Pos = 0;
        int num2Pos = 0;
        int resultPos = 0;

        while (num1Pos < m || num2Pos < n) {
            if (num1Pos == m) {
                nums1[resultPos++] = nums2[num2Pos++];
            } else if (num2Pos == n) {
                nums1[resultPos++] = num1Cpy[num1Pos++];
            } else {
                if (num1Cpy[num1Pos] <= nums2[num2Pos]) {
                    nums1[resultPos++] = num1Cpy[num1Pos++];
                } else {
                    nums1[resultPos++] = nums2[num2Pos++];
                }
            }
        }
    }
}
