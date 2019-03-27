import utils.Log;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Log.d(maxSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 3));
    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) return new int[0];
        int[] res = new int[a.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        int index  = 0;
        for (int i = 0; i < a.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
                deque.poll();

            // Remove numbers smaller than a[i] from right(a[i-1]) to left, to make the first number in the deque the largest one in the window
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i])
                deque.pollLast();

            deque.offer(i);// Offer the current index to the deque's tail

            if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements
                res[index++] = a[deque.peek()];
        }
        return res;
    }
}
