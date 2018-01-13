package number;


/**
 * 581. Shortest Unsorted Continuous Subarray
 * <p>
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort
 * this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}) == 2);
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}) == 4);
        System.out.println(findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}) == 3);
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}) == 5);
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 4, 5, 3}) == 3);
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 5, 3, 4}) == 3);
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}) == 2);
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 4, 2, 5}) == 3);
    }

    public static int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                left = i;
            }
            if (left != -1) {
                if (min > nums[i]) {
                    min = nums[i];
                }
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right = i;
            }
            if (right != -1) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
        }

        for (left = 0; left < nums.length; left++) {
            if (min < nums[left])
                break;
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right])
                break;
        }

        return right - left < 0 ? 0 : right - left + 1;

    }

}
