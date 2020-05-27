package medium.Reduce_Array_Size_to_The_Half;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;

/**
 * Runtime : 20ms(94.13%)
 * Memory : 49.5mb(100.0%)
 */
public class Solution_6 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] param = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] param = new int[]{3,3,3,3,5,5,5,2,2,7};
        PerformanceUtil.calcPerformance(new Solution_6(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return minSetSize((int[])params[0]);
    }

    public class CntObject {
        public int cnt;

        public CntObject(int cnt) {
            this.cnt = cnt;
        }
    }

    public int minSetSize(int[] arr) {
        int max = 0;
        for(int num : arr) {
            max = Math.max(max, num);
        }
        CntObject[] cntArr = new CntObject[max + 1];
        List<CntObject> cntList = new LinkedList<>();

        for(int num : arr) {
            if(cntArr[num] == null) {
                cntArr[num] = new CntObject(0);
                cntList.add(cntArr[num]);
            }
            cntArr[num].cnt++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e1 > e2 ? -1 : e1 < e2 ? 1 : 0);
        for(CntObject obj : cntList) {
            queue.offer(obj.cnt);
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
