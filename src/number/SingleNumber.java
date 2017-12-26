package number;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 * <p>
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
    public static void main(String[] args) {
        int result = singleNumber(new int[]{1, 6, 1, 44, 6, 5, 5, 9, 9, 11, 44});
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                result ^= nums[i];
            }
        }
        return result;
    }
}
