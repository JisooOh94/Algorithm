package medium.Gas_Station;

import org.junit.Test;

/**
 * Runtime : 189ms(5.37%)
 * Memory : 39.9mb(42.67%)
 */
public class Solution_2 {
    @Test
    public void test() {
        //int[] gas = new int[]{2, 3, 4}; int[] cost = new int[]{3, 4, 3};
//        int[] gas = new int[]{1,2,3,4,5}; int[] cost = new int[]{3,4,5,1,2};
        int[] gas = new int[]{3, 1, 1}; int[] cost = new int[]{1, 2, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] score = new int[gas.length];
        boolean[] unAble = new boolean[gas.length];

        for(int i = 0; i < gas.length; i++) {
            for(int j = 0; j <= i; j++) {
                score[j] += gas[i] - cost[i];
                if(score[j] < 0) unAble[j] = true;
            }
        }

        if(!unAble[0]) return 0;

        for(int i = 1; i < gas.length; i++) {
            score[i] += gas[i - 1] - cost[i - 1];
            if(0 <= score[i] && !unAble[i]) return i;
            for(int j = i + 1; j < gas.length; j++) {
                score[j] += gas[i - 1] - cost[i - 1];
                if(score[j] < 0) unAble[j] = true;
            }
        }
        return -1;
    }
}
