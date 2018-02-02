package tree;

import entity.TreeNode;
import utils.Log;

import java.util.*;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3) {{
            left = new TreeNode(9) {{
                left = new TreeNode(15);
            }};
            right = new TreeNode(20) {{
                left = new TreeNode(8);
                right = new TreeNode(7);
            }};
        }};

        Log.d(levelOrder(t1));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    valList.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            ans.add(valList);
        }
        return ans;
    }
}
