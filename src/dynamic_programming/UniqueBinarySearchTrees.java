package dynamic_programming;

import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 96. Unique Binary Search Trees
 * <p>
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1          3     3      2      1
 * 　\       /     /      / \      \
 * 　　3    2     1      1   3      2
 * 　/    /       \                  \
 * 2     1         2                  3
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Log.d(numTrees(5));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
