package medium.Gas_Station;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Runtime : 480ms(5.37%)
 * Memory : 39.9mb(42.67%)
 */
public class Solution_3 {
    @Test
    public void test() {
        int[] gas = new int[]{2, 3, 4}; int[] cost = new int[]{3, 4, 3};
//        int[] gas = new int[]{1,2,3,4,5}; int[] cost = new int[]{3,4,5,1,2};
        //int[] gas = new int[]{3, 1, 1}; int[] cost = new int[]{1, 2, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] score = new int[gas.length];
        List<Integer> idxList = IntStream.range(0, gas.length).boxed().collect(Collectors.toList());

        for(int i = 0; i < gas.length; i++) {
            for(Iterator<Integer> iter = idxList.iterator(); iter.hasNext(); ) {
                int idx = iter.next();
                if(i < idx) break;
                score[idx] += gas[i] - cost[i];
                if(score[idx] < 0) iter.remove();
            }
        }

        for(int i = 0; i < gas.length; i++) {
            for (Iterator<Integer> iter = idxList.iterator(); iter.hasNext(); ) {
                int idx = iter.next();
                if (idx == i) return idx;
                score[idx] += gas[i] - cost[i];
                if (score[idx] < 0) iter.remove();
            }
        }

        return -1;
    }
}
