package dynamic_programming;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 2, 3}));
//        System.out.println(canJump(new int[]{2, 3, 1, 0, 1, 2}));
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;

        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] == 0){
                return false;
            }
            if (dp[i - 1] <= nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] - 1;
            }
        }
        return dp[nums.length - 2] >= 1;
    }
}
