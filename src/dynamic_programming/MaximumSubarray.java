package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArrayDP(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayDP(new int[]{-2}));
        System.out.println(maxSubArrayDP(new int[]{-2, -3, -4, -6, 9}));
        System.out.println(maxSubArrayDP(new int[]{-2, -3, -1, -6, -9}));
        System.out.println(maxSubArrayDP(new int[]{1}));
    }

    public static int maxSubArrayDP(int[] nums) {
        // dp[i]表示以i为终点累积的最大和
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = num;
            else
                sum += num;
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
