package medium.Delete_Columns_to_Make_Sorted_II;

import org.junit.Test;

/**
 * Retry
 */
public class Solution {
    @Test
    public void test() {
        //String[] str = new String[]{"azzz", "bzzz", "cada", "cbcb", "dzzz", "edac", "ecbd"};
        String[] str = new String[]{"epdzz","vjoxh"};
        System.out.println(minDeletionSize(str));
    }
    public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, idx;
        boolean[] sorted = new boolean[n - 1];
        for (idx = 0; idx < m; ++idx) {
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && A[i].charAt(idx) > A[i + 1].charAt(idx)) {
                    res++;
                    break;
                }
            }
            if (i < n - 1) continue;
            for (i = 0; i < n - 1; ++i) {
                if(!sorted[i]) sorted[i] = A[i].charAt(idx) < A[i + 1].charAt(idx);
            }
        }
        return res;
    }
}
