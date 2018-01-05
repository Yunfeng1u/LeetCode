package dynamic_programming;

/**
 * 198. House Robber
 * https://leetcode.com/problems/climbing-stairs/description/
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{6, 5, 3, 6, 4, 8, 8, 9, 1, 3, 6, 5, 4}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


}
