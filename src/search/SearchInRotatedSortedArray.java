package search;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;

/**
 * todo 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        System.out.println(search(new int[]{4, 5, 6, 7,  0, 1, 2}, 0));
        System.out.println(search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 15));
//        System.out.println(search(new int[]{279, 284, 285, 287, 288, 296, 2, 8, 10, 11, 12, 13, 14, 19, 20, 22, 25, 26, 27, 28, 29, 33, 37, 39, 42, 43, 47, 48, 49, 50, 57, 62, 63, 66, 68, 69, 71, 73, 74, 77, 78, 79, 85, 89, 92, 94, 99, 111, 113, 117, 120, 122, 125, 134, 145, 152, 155, 157, 160, 161, 167, 168, 181, 182, 188, 189, 190, 194, 199, 201, 204, 208, 213, 220, 223, 225, 226, 227, 231, 237, 240, 242, 247, 254, 259, 260, 261, 264, 267, 271, 275}, 298));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
