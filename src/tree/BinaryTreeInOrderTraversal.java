package tree;

import apple.laf.JRSUIUtils;
import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * 　\
 * 　　2
 * 　/
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInOrderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4) {{
            left = new TreeNode(2) {{
                left = new TreeNode(1);
                right = new TreeNode(3);
            }};
            right = new TreeNode(7) {{
                left = new TreeNode(6);
                right = new TreeNode(9);
            }};
        }};

        TreeNode t2 = new TreeNode(1) {{
            right = new TreeNode(2) {{
                left = new TreeNode(3);
            }};
        }};

        TreeNode t3 = new TreeNode(2) {{
            left = new TreeNode(3) {{
                left = new TreeNode(1);
            }};
        }};

        Log.d(inorderTraversal(t3));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                current = node.right;
            }
        }

        return list;
    }
}
