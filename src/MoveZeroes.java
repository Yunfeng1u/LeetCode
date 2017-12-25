import utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * <p>
 * Given an array nums, write a function to move all 0's to the end
 * of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroes(array);
        Log.d(array);
    }

    public static void moveZeroes(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                for (int j = i; j < nums.length; j++) {

                }
            }
        }
    }
}
