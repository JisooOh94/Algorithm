package easy.Paint_House;

import org.junit.Test;

/**
 * Runtime : 1ms(66.42%)
 * Memory : 41.1mb(5.13%)
 */
public class Solution {
    @Test
    public void test() {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }
    public int recursion(int[][] costs, int idx, int prev) {
        if(idx == costs.length) return 0;
        int minScore = 99999999;

        for(int i = 0; i < 3; i++) {
            if(i == prev) continue;
            int result = recursion(costs, idx + 1, i) + costs[idx][i];
            if(result < minScore) minScore = result;
        }

        return minScore;
    }

    public int recursion_2(int[][] costs, int[][] record, int idx, int prev) {
        if(idx == costs.length) return 0;
        int minScore = 99999999;

        for(int i = 0; i < 3; i++) {
            if(i == prev) continue;
            int result = record[idx][i] != 0 ? record[idx][i] : recursion_2(costs, record, idx + 1, i) + costs[idx][i];
            if(result < minScore) minScore = result;
            record[idx][i] = result;
        }

        return minScore;
    }

    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int[][] record = new int[costs.length][costs[0].length];
        return recursion_2(costs, record, 0, -1);
    }
}
