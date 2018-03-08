package tree;

import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * 　\
 * 　　2
 * 　/
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreOrderTraversal {
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

        Log.d(preorderTraversal(t1));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null){
                stack.push(current);
                list.add(current.val);
                current = current.left;
            }else {
                current= stack.pop().right;
            }
        }

        return list;
    }
}
