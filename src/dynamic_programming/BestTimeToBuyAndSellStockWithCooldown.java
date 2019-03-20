package dynamic_programming;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO blog
 * TODO 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times)
 * with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,4}));
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] stateCooldown = new int[prices.length];
        int[] stateBuy = new int[prices.length];
        int[] stateSell = new int[prices.length];

        stateCooldown[0] = 0;
        stateBuy[0] = -prices[0];
        stateSell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            stateCooldown[i] = Math.max(stateCooldown[i - 1], stateSell[i - 1]);
            stateBuy[i] = Math.max(stateBuy[i - 1], stateCooldown[i - 1] - prices[i]);
            stateSell[i] = stateBuy[i - 1] + prices[i];
        }
        return Math.max(stateCooldown[prices.length - 1], stateSell[prices.length - 1]);
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(buy[0] + prices[1], sell[0]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }
}
