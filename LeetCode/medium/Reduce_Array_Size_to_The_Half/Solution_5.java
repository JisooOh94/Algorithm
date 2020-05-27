package medium.Reduce_Array_Size_to_The_Half;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Runtime : 11ms(97.29%)
 * Memory : 49.2mb(100.0%)
 */
public class Solution_5 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] param = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] param = new int[]{3,3,3,3,5,5,5,2,2,7};
        PerformanceUtil.calcPerformance(new Solution_5(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return minSetSize((int[])params[0]);
    }

    public int minSetSize(int[] arr) {
        int max = 0;
        for(int num : arr) {
            max = Math.max(max, num);
        }
        int[] cntArr = new int[max + 1];

        for(int num : arr) {
            cntArr[num]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e1 > e2 ? -1 : e1 < e2 ? 1 : 0);
        for(int cnt : cntArr) {
            if(cnt != 0) {
                queue.offer(cnt);
            }
        }

        int halfSize = arr.length / 2;

        int totalCnt = 0;
        while(!queue.isEmpty()) {
            halfSize -= queue.poll();
            totalCnt++;
            if(halfSize <= 0) break;
        }

        return totalCnt;
    }
}
