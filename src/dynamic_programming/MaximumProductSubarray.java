package dynamic_programming;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{2, -3, -2, 4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, -2, 4, 6, -118}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int accMax = nums[0];
        int accNegativeMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                accMax = Math.max(nums[i], accMax * nums[i]);
                accNegativeMax = Math.min(nums[i], accNegativeMax * nums[i]);
            } else {
                int temp = accMax;
                accMax = Math.max(nums[i], accNegativeMax * nums[i]);
                accNegativeMax = Math.min(nums[i], temp * nums[i]);
            }
            if (accMax > max) {
                max = accMax;
            }
        }

        return max;
    }

    public static int maxProduct2(int[] nums) {

        int max = nums[0];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(leftProduct *= nums[i], max);
            if (nums[i] == 0) {
                leftProduct = 1;
                max = Math.max(0, max);
            }
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            max = Math.max(rightProduct *= nums[i], max);
            if (nums[i] == 0) {
                rightProduct = 1;
                max = Math.max(0, max);
            }
        }

        return max;
    }
}
