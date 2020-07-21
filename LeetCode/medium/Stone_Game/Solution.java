package medium.Stone_Game;

import org.junit.Test;

/**
 * Runtime : 54ms(10.17%)
 * Memory : 49.1mb(9.84%)
 */
public class Solution {
    private static int A = 0;
    private static int B = 1;
    @Test
    public void execute() {
        int[] arr = new int[]{5, 3, 4, 5};
        System.out.println(stoneGame(arr));
    }

    private int[] recursion(int startIdx, int endIdx, int turn, int[] arr, int[][][] record) {
        if (startIdx == endIdx) return new int[]{0, arr[startIdx]};
        else if (record[startIdx][endIdx][0] != 0) return new int[]{record[startIdx][endIdx][0], record[startIdx][endIdx][1]};

        int[] result;
        int cur;

        if (arr[startIdx] == arr[endIdx]) {
            cur = arr[startIdx];
            int[] result_1 = recursion(startIdx + 1, endIdx, (turn + 1) % 2, arr, record);
            int[] result_2 = recursion(startIdx, endIdx - 1, (turn + 1) % 2, arr, record);

            result = result_1[A] > result_2[A] ? result_1 : result_2;
        } else {
            cur = arr[startIdx] > arr[endIdx] ? turn == A ? arr[startIdx++] : arr[endIdx--] : turn == A ? arr[endIdx--] : arr[startIdx++];
            result = recursion(startIdx, endIdx, (turn + 1) % 2, arr, record);
        }

        result[turn] += cur;
        record[startIdx][endIdx][A] = result[A];
        record[startIdx][endIdx][B] = result[B];

        return result;
    }

    public boolean stoneGame(int[] piles) {
        int[][][] record = new int[piles.length][piles.length][2];

        int[] result = recursion(0, piles.length - 1, A, piles, record);

        return result[0] > result[1];
    }
//
//    private int[] recursion(int startIdx, int endIdx, int[]arr, int[][][] record) {
//        if(startIdx == endIdx -1) return new int[]{Math.max(arr[startIdx], arr[endIdx]), Math.min(arr[startIdx], arr[endIdx])};
//        else if(record[startIdx][endIdx][0] != 0) return new int[]{record[startIdx][endIdx][0], record[startIdx][endIdx][1]};
//
//        int curMin, curMax;
//        int[] result;
//
//        if(arr[startIdx] == arr[endIdx]) {
//            curMax = curMin = arr[startIdx];
//
//            int[] result_1 = arr[startIdx + 1] >
//
//            int[] result_1 = recursion(startIdx + 1, endIdx, arr, record);
//            int[] result_2 = recursion(startIdx, endIdx - 1, arr, record);
//
//            result = result_1[0] > result_2[0] ? result_1 : result_2;
//        } else {
//            curMax = arr[startIdx] > arr[endIdx] ? arr[startIdx++] : arr[endIdx--];
//            curMin = arr[startIdx] > arr[endIdx] ? arr[endIdx--] : arr[startIdx++];
//
//            result = recursion(startIdx, endIdx, arr, record);
//        }
//
//        result[0] += curMax;
//        result[1] += curMin;
//
//        record[startIdx][endIdx][0] = result[0];
//        record[startIdx][endIdx][1] = result[1];
//
//        return result;
//    }

}
