package medium.Longest_Arithmetic_Sequence;

import org.junit.Test;

/**
 * Runtime : 2126ms(5.13%)
 * Memory : 37.1mb(100.00%)
 */
public class Solution {
    @Test
    public void execute() {
//        int[] A = new int[]{3,6,9,12};
//        int[] A = new int[]{9,4,7,2,10};
        int[] A = new int[]{20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(A));
    }
    private int chkLength(int startIdx, int gap, int[] arr) {
        int curLength = 0;
        int prev = arr[startIdx];

        for(int i = startIdx + 1; i < arr.length; i++) {
            if(arr[i] - prev == gap) {
                curLength++;
                prev = arr[i];
            }
        }
        return curLength;
    }

    public int longestArithSeqLength(int[] A) {
        int maxLength = 0;

        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; j++) {
                int curLength = chkLength(j, A[j] - A[i], A);
                maxLength = Math.max(maxLength, curLength);
            }
        }

        return maxLength + 2;
    }
}
