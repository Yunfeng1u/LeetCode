package dynamic_programming;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * <p>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{32, 12, 5}, 11));
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int temp = dp[i - coins[j]];
                    if (temp != -1) {
                        if (dp[i] != -1) {
                            dp[i] = Math.min(dp[i], temp + 1);
                        } else {
                            dp[i] = temp + 1;
                        }
                    }
                }
            }
        }
        return dp[amount];
    }


    int minCount = Integer.MAX_VALUE;

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        count(amount, coins.length - 1, coins, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    void count(int amount, int index, int[] coins, int count) {
        if (amount % coins[index] == 0) {
            int newCount = count + amount / coins[index];
            if (newCount < minCount)
                minCount = newCount;
            //return;  // Not sure why return here will slow down in OJ. It's better in my local test however.
        }

        if (index == 0)
            return;

        for (int i = amount / coins[index]; i >= 0; i--) {
            int newAmount = amount - i * coins[index];
            int newCount = count + i;

            int nextCoin = coins[index - 1];
            if (newCount + (newAmount + nextCoin - 1) / nextCoin >= minCount)
                break;

            count(newAmount, index - 1, coins, newCount);
        }
    }
}
