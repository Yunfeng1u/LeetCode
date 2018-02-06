package tree;

import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * <p>
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * <p>
 * 1          3     3      2      1
 * 　\       /     /      / \      \
 * 　　3    2     1      1   3      2
 * 　/    /       \                  \
 * 2     1         2                  3
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    static List<TreeNode>  generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
