package dynamic_programming;

import entity.Interval;

import java.util.*;

/**
 * 646. Maximum Length of Pair Chain
 * <p>
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * <p>
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed.
 * You needn't use up all the given pairs.
 * You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs1 = new int[][]{
                {1, 9}, // 1
                {2, 3}, // 2
                {3, 4}, // 1
                {4, 5}, // 1
                {6, 7}, // 1
                {8, 9}, // 1
        };

        int[][] pairs2 = new int[][]{
                {-6, 9}, // 1
                {1, 6}, // 2
                {8, 10}, // 1
                {-1, 4}, // 1
                {-6, -2}, // 1
                {-9, 8}, // 1
                {-5, 3}, // 1
                {0, 3}, // 1
        };

        System.out.println(findLongestChain(pairs1));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs)
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        return ans;
    }
}
