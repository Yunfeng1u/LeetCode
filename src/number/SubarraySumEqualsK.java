package number;


/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000]
 * and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0,1,0}, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2) return false;

        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int sum = sums[j] - sums[i];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                } else if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
