package number;


/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * <p>
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p>
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 90, 1, 5, 3, 6, 9, 4, 8}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                if (sum < prices[i] - min) {
                    sum = prices[i] - min;
                }
            }
        }

        return sum;
    }
}
