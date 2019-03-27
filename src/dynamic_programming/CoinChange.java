package dynamic_programming;

/**
 * TODO blog
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
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
//        System.out.println(coinChange(new int[]{32, 12, 5}, 11));
        System.out.println(coinChange(new int[]{5, 1, 2}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // dp[i]为凑够i元所需要的最少硬币数
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                // 大于i元则无法组成i
                if (coin <= i) {
                    // 凑够i-coin元所需要的最少硬币数
                    int temp = dp[i - coin];
                    if (temp != -1) {
                        // 如果已有硬币组合可以组成凑够i，取较少值
                        if (dp[i] != -1) {
                            dp[i] = Math.min(dp[i], temp + 1);
                        }
                        // 如果目前没有硬币组合可以组成凑够i，用之前凑够i-coin元所需要的最少硬币数，凑上coin，刚好是i，所以数量加1
                        else {
                            dp[i] = temp + 1;
                        }
                    } else {
                        // 如果无法凑够i-coin元，以当前的coin来说，也就无法凑够i元，等待下次循环
                    }
                }
            }
        }
        return dp[amount];
    }
}
