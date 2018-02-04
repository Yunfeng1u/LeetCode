package tree;

import entity.TreeNode;
import utils.Log;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3) {{
            left = new TreeNode(9) {{
                left = new TreeNode(15);
            }};
            right = new TreeNode(20) {{
                right = new TreeNode(7);
            }};
        }};

        Log.d(levelOrderBottom(t1));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

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

        Collections.reverse(ans);

        return ans;
    }
}
