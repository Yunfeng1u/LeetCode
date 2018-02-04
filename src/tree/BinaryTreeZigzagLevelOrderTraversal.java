package tree;

import entity.TreeNode;
import utils.Log;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3) {{
            left = new TreeNode(9);
            right = new TreeNode(20) {{
                left = new TreeNode(15);
                right = new TreeNode(7);
            }};
        }};
        TreeNode t2 = new TreeNode(1) {{
            left = new TreeNode(2){{
                left = new TreeNode(4);
            }};
            right = new TreeNode(3) {{
                right = new TreeNode(5);
            }};
        }};
        Log.d(zigzagLevelOrder(t2));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        List<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean order = false;
        while (!queue.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (order) {
                    TreeNode node = queue.remove(0);
                    valList.add(node.val);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                } else {
                    TreeNode node = queue.remove(queue.size() - 1);
                    valList.add(node.val);
                    if (node.left != null) {
                        queue.add(0, node.left);
                    }
                    if (node.right != null) {
                        queue.add(0, node.right);
                    }
                }
            }
            order = !order;
            ans.add(valList);
        }

        return ans;
    }
}
