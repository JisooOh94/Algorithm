package medium.Reduce_Array_Size_to_The_Half;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_4 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        int[] param = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] param = new int[]{3,3,3,3,5,5,5,2,2,7};
        PerformanceUtil.calcPerformance(new Solution_4(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return minSetSize((int[])params[0]);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = arr.length / 2;

        int inverseIdx = arr.length - 1;
        for(int i = 0; i < half; i++) {
            int cnt = map.getOrDefault(arr[i], 0);
            map.put(arr[i], cnt + 1);

            int cnt_2 = map.getOrDefault(arr[inverseIdx], 0);
            map.put(arr[inverseIdx], cnt_2 + 1);
            inverseIdx--;
        }

        List<Integer> cntList = map.values().stream().collect(Collectors.toList());
        Collections.sort(cntList, Collections.reverseOrder());

        for(int i = 0; i < cntList.size(); i++) {
            half -= cntList.get(i);
            if(half <= 0) return i + 1;
        }
        return 0;
    }
}
