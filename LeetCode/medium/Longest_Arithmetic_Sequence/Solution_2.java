package medium.Longest_Arithmetic_Sequence;

import org.junit.Test;

/**
 * Runtime : 1512(5.13%)
 * Memory : 42.3mb(94.94%)
 */
public class Solution_2 {
    @Test
    public void execute() {
//        int[] A = new int[]{3,6,9,12};
        int[] A = new int[]{9,4,7,2,10};
//        int[] A = new int[]{20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(A));
    }
    private int chkLength(int startIdx, int gap, int[] arr, boolean[][] visited) {
        int curLength = 0;
        int prevIdx = startIdx;

        for(int i = startIdx + 1; i < arr.length; i++) {
            if(arr[i] - arr[prevIdx] == gap) {
                visited[prevIdx][i] = true;
                curLength++;
                prevIdx = i;
            }
        }
        return curLength;
    }

    public int longestArithSeqLength(int[] A) {
        int maxLength = 0;
        boolean[][] visited = new boolean[A.length][A.length];

        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(visited[i][j]) continue;
                int curLength = chkLength(j, A[j] - A[i], A, visited);
                maxLength = Math.max(maxLength, curLength);
            }
        }

        return maxLength + 2;
    }
}
