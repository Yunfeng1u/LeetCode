package number;


import utils.Log;

/**
 * 75. Sort Colors
 * <p>
 * https://leetcode.com/problems/sort-colors/description/
 * <p>
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] colors = new int[]{0};
        sortColors(colors);
        Log.d(colors);
    }

    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        for (int i = 0; i < counts[0]; i++) {
            nums[i] = 0;
        }
        for (int i = counts[0]; i < counts[0] + counts[1]; i++) {
            nums[i] = 1;
        }
        for (int i = counts[0] + counts[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
