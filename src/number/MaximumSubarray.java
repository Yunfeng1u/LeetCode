package number;

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
        int result = maxSubArrayDP(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
        System.out.println(maxSubArrayDP(new int[]{-2}));
        System.out.println(maxSubArrayDP(new int[]{-2, -3, -4, -6, 9}));
        System.out.println(maxSubArrayDP(new int[]{-2, -3, -1, -6, -9}));
        System.out.println(maxSubArrayDP(new int[]{1}));
    }

    public static int maxSubArrayDP(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
            if (dp[i] < nums[i]){
                dp[i] = nums[i];
            }
            if (max < dp[i]){
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
