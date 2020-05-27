package medium.Reduce_Array_Size_to_The_Half;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_2 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] param = new int[]{3,3,3,3,5,5,5,2,2,7};
//        int[] param = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] param = new int[]{9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        PerformanceUtil.calcPerformance(new Solution_2(), (Object)param);
    }

    @Override
    public Integer test(Object... params) {
        return minSetSize((int[])params[0]);
    }

    public class CntObject implements Comparable<CntObject> {
        public int cnt;

        public CntObject(int cnt) {
            this.cnt = cnt;
        }

        @Override
        public int compareTo(CntObject object) {
            return this.cnt > object.cnt ? -1 : this.cnt < object.cnt ? 1 : 0;
        }

        @Override
        public String toString() {
            return String.valueOf(cnt);
        }
    }

    public int minSetSize(int[] arr) {
        Map<Integer, CntObject> map = new HashMap<>();
        PriorityQueue<CntObject> queue = new PriorityQueue<>();

        for(int num : arr) {
            CntObject obj = map.getOrDefault(num, new CntObject(0));
            if(obj.cnt == 0) queue.offer(obj);
            obj.cnt += 1;
            map.put(num, obj);
        }

        int halfSize = arr.length / 2;

        int totalCnt = 0;
        while(!queue.isEmpty()) {
            halfSize -= queue.poll().cnt;
            totalCnt++;
            if(halfSize <= 0) break;
        }

        return totalCnt;
    }
}
