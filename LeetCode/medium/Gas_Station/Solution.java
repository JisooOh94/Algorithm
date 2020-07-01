package medium.Gas_Station;

import org.junit.Test;

/**
 * Runtime : 203ms(5.37%)
 * Memory : 40.1mb(22.92%)
 */
public class Solution {
    @Test
    public void test() {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] score = new int[gas.length];
        boolean[] able = new boolean[gas.length];

        for(int i = 0; i < gas.length; i++) {
            for(int j = 0; j <= i; j++) {
                score[j] += gas[i] - cost[i];
                if(score[j] < 0) able[j] = true;
            }
        }

        for(int i = 0; i < gas.length; i++) {
            for(int j = i + 1; j < gas.length; j++) {
                score[j] += gas[i] - cost[i];
                if(score[j] < 0) able[j] = true;
            }
        }

        for(int i = 0; i < able.length; i++) {
            if(able[i] == false){
                return i;
            }
        }
        return -1;
    }
}
