import utils.Log;

import java.util.Arrays;

/**
 * todo 300. Longest Increasing Subsequence
 * <p>
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] numbers = new int[]{
                2,5,3,5,6,7,1,2,8
        };
        Log.d(lengthOfLIS(numbers));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if(i == len) {
                len++;
            }
        }

        return len;
    }

}
