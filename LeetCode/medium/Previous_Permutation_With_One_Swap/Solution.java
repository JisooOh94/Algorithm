package medium.Previous_Permutation_With_One_Swap;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.PriorityQueue;

/**
 * Runtime : 1ms(13.08%)
 * Memory : 53.2mb(5.11%)
 */
public class Solution implements Predicate<int[], Object> {
    @Test
    public void execute() {
//        int[] param = new int[]{3,2,1};
//        int[] param = new int[]{1, 1, 5};
        int[] param = new int[]{1,9,4,6,7};
//        int[] param = new int[]{3, 1, 1, 3};

        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
    }

    @Override
    public int[] test(Object... params) {
        int[] result = prevPermOpt1((int[])params[0]);
        for(int num : result) {
            System.out.print(num + ", ");
        }
        return result;
    }

    public int[] prevPermOpt1(int[] A) {
        if(A.length == 1) return A;
        // 0 : val, 1 : idx
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : e1[1] < e2[1] ? 1 : e1[1] > e2[1] ? -1 : 0);

        minQueue.add(new int[]{A[A.length - 1], A.length - 1});

        for(int i = A.length - 2; i >= 0; i--) {
            int[] minVal = minQueue.peek();

            if(minVal[0] < A[i]) {
                minVal = minQueue.poll();
                while(!minQueue.isEmpty()) {
                    int[] maxVal = minQueue.poll();
                    if(A[i] <= maxVal[0]) {
                        break;
                    }

                    minVal = maxVal;
                }
                int temp = A[i];
                A[i] = A[minVal[1]];
                A[minVal[1]] = temp;
                break;
            } else {
                minQueue.add(new int[]{A[i], i});
            }
        }

        return A;
    }
}
