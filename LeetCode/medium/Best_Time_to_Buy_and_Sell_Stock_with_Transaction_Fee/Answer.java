package medium.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

/**
 * Runtime : 4ms(10%)
 * Memory : 49.8MB(25.90%)
 */
//![image](https://user-images.githubusercontent.com/48702893/84404662-18ac8580-ac42-11ea-90b6-82e790fb43f8.png)
public class Answer {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] hold   = new int[len];
        int[] unhold = new int[len];
        hold[0] = -prices[0];

        for (int i = 1; i < len; i++){
            int cur = prices[i];
            hold[i]   = Math.max(hold[i - 1], unhold[i - 1] - cur);
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + cur - fee);
        }

        return unhold[len - 1];
    }
}
