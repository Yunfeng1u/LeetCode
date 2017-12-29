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
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if(n == 0) return 0;
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
