package tree;

import entity.TreeNode;

import java.util.*;

/**
 * todo 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 * according to the LCA definition.
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorOfaBinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3) {{
            left = new TreeNode(5) {{
                left = new TreeNode(6);
                right = new TreeNode(2) {{
                    left = new TreeNode(7);
                    right = new TreeNode(4);
                }};
            }};
            right = new TreeNode(1) {{
                left = new TreeNode(0);
                right = new TreeNode(8);
            }};
        }};

        TreeNode node = lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(1));

        System.out.println(node);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
