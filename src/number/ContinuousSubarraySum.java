package number;


/**
 * TODO 523. Continuous Subarray Sum
 * <p>
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 * <p>
 * Given a list of non-negative numbers and a target integer k, write a function to
 * check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 * that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * <p>
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0, 1, 0, -1}, 0));
//        System.out.println(checkSubarraySum(new int[]{1,1,1}, 2));
    }

    public static  boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2) return false;

        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int sum = sums[j] - sums[i - 1];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                } else {
                    if (sum % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
