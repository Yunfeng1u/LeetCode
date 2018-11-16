package dynamic_programming;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 采用动态规划的思想，定义一个长度为n的数组，数组的第i项代表，到达第i+1级共有几种途径
        int[] dp = new int[n];

        // 到达第1级共有1种途径
        dp[0] = 1;
        // 到达第2级共有2种途径
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            // 到达第i级，因为只有从第i-1级和第i-2级才能到达第i级，所以只需要把第i-1级和第i-2级累计的途径数量加起来即可
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 到达最后高一级共有dp[n - 1]种途径
        return dp[n - 1];
    }

    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int part1 = 1;
        int part2 = 2;

        int count = 0;

        for (int i = 3; i <= n; i++) {
            count = part1 + part2;
            part1 = part2;
            part2 = count;
        }

        return count;
    }


}
