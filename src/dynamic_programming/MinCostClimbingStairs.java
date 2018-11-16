package dynamic_programming;

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs2(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs2(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        // 由于题目说明中提到，攀登阶梯时，有两种走法，固然对于每级阶梯也有两种状态
        // 此处将其定义为：0 - 该阶梯跳过，直接去往下一级；1 - 停留在该阶梯，缴费
        // 定义一个大小为 阶梯数目 * 2 的二维数组，每行表示每级阶梯的最小累计费用，其中每行包括两种状态，0-跳过或1-停留
        int[][] dp = new int[cost.length][2];

        // 从上面的分析可以看出，后一个阶梯依赖于前面的阶梯，不难想到，我们需要把最初始的情况先计算出来
        // 1. 首个阶梯跳过，在当前阶梯就自然不用花费
        dp[0][0] = 0;
        // 2. 首个阶梯停留，就需要交纳该阶级费用
        dp[0][1] = cost[0];

        for (int i = 1; i < dp.length; i++) {
            // 1. 计算第i个阶梯跳过的情况
            // 若该阶梯跳过，因为不可能连续跳过两级，那么上一个阶梯必定停留，所以累计费用 = 停留上一个阶梯的累计费用dp[i - 1][1]
            dp[i][0] = dp[i - 1][1];
            // 2. 计算第i个阶梯停留的情况
            // 这里要分两种情况，上一级可能停留dp[i - 1][1]，也可能被跳过dp[i - 1][0]，两种情况的累计费用可能不同，显然我们只需要最小的费用
            // 因为该阶梯要停留，所以需要交纳该级的费用cost[i]
            dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i];
        }
        // 最后一级时，根据停留或跳过两种情况，取最小的累计费用即可
        return Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        // 保存上一个阶梯跳过的情况下，累计的费用
        int prevSkip = 0;
        // 保存上一个阶梯停留的情况下，累计的费用
        int prevStay = cost[0];

        for (int i = 1; i < cost.length; i++) {

            int currentSkip = prevStay;

            int currentStay = Math.min(prevStay, prevSkip) + cost[i];

            prevSkip = currentSkip;
            prevStay = currentStay;
        }
        return Math.min(prevSkip, prevStay);
    }


    // 10,15,20
    public int minCostClimbingStairs3(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
