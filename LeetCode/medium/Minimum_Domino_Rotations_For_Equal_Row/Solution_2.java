package medium.Minimum_Domino_Rotations_For_Equal_Row;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 3ms(98.60%)
 * Memory : 46.7mb(95.90%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};

//        int[] A = new int[]{3,5,1,2,3};
//        int[] B = new int[]{3,6,3,3,4};

//        int[] A = {1, 2, 1, 1, 1, 2, 2, 2};
//        int[] B = {2, 1, 2, 2, 2, 2, 2, 2};
        PerformanceUtil.calcPerformance(new Solution_2(), (Object) A, (Object) B);
    }

    @Override
    public Integer test(Object... params) {
        return minDominoRotations((int[]) params[0], (int[]) params[1]);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int criteria = 0;
        int criteriaCnt_A = 0;
        int criteriaCnt_B = 0;

        boolean foundUnique = false;

        int initNumA = A[0];
        int initNumB = B[0];
        int initIdx = 1;


        while (!foundUnique && initIdx < A.length) {
            int curNumA = A[initIdx];
            int curNumB = B[initIdx];
            initIdx++;

            if (initNumA == initNumB) {
                if (curNumA == curNumB && curNumA == initNumA) {
                    continue;
                } else if (curNumA == curNumB && curNumA != initNumA) {
                    return -1;
                } else {
                    if (initNumA == curNumA || initNumA == curNumB) {
                        criteria = initNumA;
                        break;
                    } else if (initNumB == curNumA || initNumB == curNumB) {
                        criteria = initNumB;
                        break;
                    } else return -1;
                }
            } else {
                if (initNumA == curNumA && initNumB == curNumB || initNumA == curNumB && initNumB == curNumA) {
                    continue;
                } else {
                    if (initNumA == curNumA || initNumA == curNumB) {
                        criteria = initNumA;
                        break;
                    } else if (initNumB == curNumA || initNumB == curNumB) {
                        criteria = initNumB;
                        break;
                    } else return -1;
                }
            }
        }

        if(criteria == 0) return 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                if (A[i] != criteria) return -1;
            } else {
                if (A[i] == criteria) criteriaCnt_A++;
                else if (B[i] == criteria) criteriaCnt_B++;
                else return -1;
            }
        }

        return Math.min(criteriaCnt_A, criteriaCnt_B);
    }
}
