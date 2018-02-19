package number;


import java.util.Arrays;
import java.util.Collections;

/**
 * 416. Partition Equal Subset Sum
 * <p>
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * <p>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));// 3,5,6  1,2,4,7
        System.out.println(canPartition(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(canPartition(new int[]{1, 2, 2, 2, 3, 4, 6}));
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    public static boolean canPartition(int[] nums) {

        if(nums == null || nums.length == 0)
            return true;
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0 ) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; --j)
                dp[j] = dp[j] || dp[j - num];
        }
        return dp[sum];
    }
}
