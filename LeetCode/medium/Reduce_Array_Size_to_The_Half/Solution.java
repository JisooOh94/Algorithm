package medium.Reduce_Array_Size_to_The_Half;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Runtime : 37ms(68.74%)
 * Memory : 49.5mb(100.0%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int[] param = new int[]{1,2,3,4,5,6,7,8,9,10};
        PerformanceUtil.calcPerformance(new Solution(), (Object)param);
    }
    @Override
    public Integer test(Object... params) {
        return minSetSize((int[])params[0]);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length / 2;

        for(int num : arr) {
            int cnt = map.getOrDefault(num, 0);
            if(cnt + 1 >= length) return 1;
            map.put(num, cnt + 1);
        }

        List<Integer> cntList = map.values().stream().collect(Collectors.toList());
        Collections.sort(cntList, Collections.reverseOrder());

        for(int i = 0; i < cntList.size(); i++) {
            length -= cntList.get(i);
            if(length <= 0) return i + 1;
        }
        return 0;
    }
}
