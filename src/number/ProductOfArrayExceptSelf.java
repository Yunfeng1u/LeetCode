package number;

import utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 238. Product of Array Except Self
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * <p>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1,2,3,4});
        Log.d(result);
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
