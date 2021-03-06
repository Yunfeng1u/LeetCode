package number;


/**
 * TODO 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of
 * continuous subarrays whose sum equals to k.
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
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        // 初始化一个辅助的数组，长度为nums.length+1，数组第i项表示nums[0]到nums[i-1]的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                // 计算j与i间的差值，若等于k则代表，i与j连续区间符合条件
                int sum = sums[j] - sums[i];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
