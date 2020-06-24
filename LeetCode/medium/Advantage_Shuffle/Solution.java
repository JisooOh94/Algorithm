package medium.Advantage_Shuffle;

import org.junit.Test;

import java.util.*;

/**
 * Runtime : 37ms(56.60)
 * Memory : 42.3mb(46.90%)
 */
public class Solution {
    @Test
    public void test() {
//        int[] arr = new int[]{2,7,11,15};
//        int[] brr = new int[]{1,10,4,11};
//        int[] arr = new int[]{12,24,8,32};
//        int[] brr = new int[]{13,25,32,11};
//        int[] arr = new int[]{1,2,3,4};
//        int[] brr = new int[]{5,6,7,8};
        int[] arr = new int[]{2,0,4,1,2};
        int[] brr = new int[]{1,3,0,0,2};

        int[] resultArr = advantageCount(arr, brr);
        for (int num : resultArr) {
            System.out.print(num + ", ");
        }
    }

    public int[] advantageCount(int[] arr, int[] brr) {
        int resultArr[] = new int[arr.length];
        PriorityQueue<int[]> bq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));

        for (int i = 0; i < brr.length; i++) {
            bq.offer(new int[]{brr[i], i});
        }
        Arrays.sort(arr);

        List<Integer> aLeft = new LinkedList<>();
        int[] bVal = bq.poll();
        for (int i = 0; i < arr.length; i++) {
            if (bVal[0] < arr[i]) {
                resultArr[bVal[1]] = arr[i];
                bVal = bq.poll();
            } else {
                aLeft.add(arr[i]);
            }
        }

        if (bVal != null) {
            for (Iterator iter = aLeft.iterator(); iter.hasNext(); ) {
                resultArr[bVal[1]] = (Integer) iter.next();
                bVal = bq.poll();
            }
        }

        return resultArr;
    }
}
