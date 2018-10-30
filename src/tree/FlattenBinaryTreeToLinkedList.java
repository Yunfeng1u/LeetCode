package tree;

import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1) {{
            left = new TreeNode(2) {{
                left = new TreeNode(3);
                right = new TreeNode(4);
            }};
            right = new TreeNode(5) {{
                right = new TreeNode(6);
            }};
        }};
        flatten(t);
    }

    private static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
