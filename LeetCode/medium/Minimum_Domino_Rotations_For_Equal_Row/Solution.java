package medium.Minimum_Domino_Rotations_For_Equal_Row;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 7ms(30.79%)
 * Memory : 46.8mb(90.74%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] A = new int[]{2,1,2,4,2,2};
//        int[] B = new int[]{5,2,6,2,3,2};

//        int[] A = new int[]{3,5,1,2,3};
//        int[] B = new int[]{3,6,3,3,4};

        int[] A = {1,2,1,1,1,2,2,2};
        int[] B = {2,1,2,2,2,2,2,2};
        PerformanceUtil.calcPerformance(new Solution(), (Object)A, (Object)B);
    }
    @Override
    public Integer test(Object... params) {
        return minDominoRotations((int[])params[0], (int[])params[1]);
    }
    public int minDominoRotations(int[] A, int[] B) {
        int[] appearCnt = new int[6];
        int aCnt[] = new int[6];
        int bCnt[] = new int[6];
        int length = A.length;
        int maxIdx = 0;

        for(int i = 0; i < length; i++) {
            if(A[i] == B[i]) {
                appearCnt[A[i] - 1]++;
                if(appearCnt[maxIdx] < appearCnt[A[i] - 1]) maxIdx = A[i] - 1;
            } else {
                appearCnt[A[i] - 1]++;
                appearCnt[B[i] - 1]++;
                if(appearCnt[maxIdx] < appearCnt[A[i] - 1]) maxIdx = A[i] - 1;
                if(appearCnt[maxIdx] < appearCnt[B[i] - 1]) maxIdx = B[i] - 1;

                aCnt[A[i] - 1]++;
                bCnt[B[i] - 1]++;
            }
        }

        if(appearCnt[maxIdx] == length) {
            return Math.min(aCnt[maxIdx], bCnt[maxIdx]);
        } else {
            return -1;
        }
    }
}
