package easy.Best_Time_to_Buy_and_Sell_Stock;

import org.junit.Test;

/**
 * Runtime : 1ms(99.29%)
 * Memory : 41.3mb(18.19%)
 */
public class Solution {
    @Test
    public void test() {
//        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        int max = prices[prices.length - 1];

        for(int i = prices.length - 2; 0 <= i; i--) {
            if(prices[i] > max) max = prices[i];
            else if(prices[i] < max) maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    }
}
