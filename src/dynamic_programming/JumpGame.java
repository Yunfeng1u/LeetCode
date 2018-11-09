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

        // 使用动态规划的解法
        // 声明一个int类型的数组，用于储存在某个位置的最大可用步数，可以看出dp的长度为nums.length - 1，
        // 因为我们只需要知道到达倒数第二位时是否还有可用步数，不需理会最后一个位置
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            // 如果上一个位置的最大可用步数为0，那就再也走不动了，返回`false`
            if (dp[i - 1] == 0){
                return false;
            }
            // 如果上个位置剩余的步数dp[i - 1]小于或等于当前位置拥有的步数nums[i]，就停留接受补给
            // 当前位置最大可用步数更新为nums[i]
            if (dp[i - 1] <= nums[i]) {
                dp[i] = nums[i];
            }
            // 如果上个位置剩余的步数dp[i - 1]比当前位置拥有的步数nums[i]还富裕，就消耗1步，继续前进
            // 当前最大可用步数更新为dp[i - 1] - 1
            else {
                dp[i] = dp[i - 1] - 1;
            }
        }
        // 最后只需判断倒数第二个位置是否还有可用步数
        return dp[nums.length - 2] >= 1;
    }
}
