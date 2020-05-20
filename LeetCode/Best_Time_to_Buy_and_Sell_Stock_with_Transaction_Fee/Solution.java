package Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

import util.Predicate;

import java.util.Arrays;

//Failed
public class Solution implements Predicate<Integer, Object> {
    @Override
    public Integer test(Object... params) {
        return maxProfit((int[])params[0], (int)params[1]);
    }

    private int[] totalMaxBuyProfit;
    private boolean[] isVIsited;

    private int buyRecursion(int startIdx, int[] prices, int fee) {
        if(isVIsited[startIdx]) return totalMaxBuyProfit[startIdx];

        int maxProfit = 0;
        for(int i = startIdx; i < prices.length - 1; i++) {
            int profit = sellRecursion(i + 1, prices[i], prices, fee);

            if(maxProfit < profit) {
                maxProfit = profit;
            }
        }
        isVIsited[startIdx] = true;
        totalMaxBuyProfit[startIdx] = maxProfit;
        return maxProfit;
    }

    private int sellRecursion(int stgartIdx, int buyPrice, int[] prices, int fee) {
        int maxProfit = 0;
        for(int i = stgartIdx; i < prices.length; i++) {
            if(buyPrice + fee < prices[i]) {
                int profit = prices[i] - buyPrice - fee;
                if(prices.length > i + 1) profit += buyRecursion(i + 1, prices, fee);

                if(maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 1) return 0;

        totalMaxBuyProfit = new int[prices.length];
        isVIsited = new boolean[prices.length];

        return buyRecursion(0, prices, fee);
    }
}
