package easy.Min_Cost_Climbing_Stairs;

import org.junit.Test;

/**
 * Runtime : 2ms(13.03%)
 * Memory : 41.3mb(5.06%)
 */
public class Solution {
    @Test
    public void test() {
//        int[] cost = new int[]{10, 15, 20};
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public int recursion(int idx, int[] cost, int[] record) {
        if(idx >= cost.length) return 0;

        int cost_1 = idx + 1 < cost.length && record[idx + 1] != 0 ? record[idx + 1] : recursion(idx + 1, cost, record);
        int cost_2 = idx + 2 < cost.length && record[idx + 2] != 0 ? record[idx + 2] : recursion(idx + 2, cost, record);

        record[idx] = cost[idx] + Math.min(cost_1, cost_2);
        return record[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] record = new int[cost.length];
        return Math.min(recursion(0, cost, record), recursion(1, cost, record));
    }
}
