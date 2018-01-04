package tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 101. Symmetric Tree
 * <p>
 * https://leetcode.com/problems/symmetric-tree/description/
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1) {{
            left = new TreeNode(2) {{
                left = new TreeNode(3);
                right = new TreeNode(4);
            }};
            right = new TreeNode(2) {{
                left = new TreeNode(4);
                right = new TreeNode(3){{
                    left = new TreeNode(4);
                }};
            }};
        }};

        TreeNode t2 = new TreeNode(1) {{
            left = new TreeNode(2) {{
                right = new TreeNode(3);
            }};
            right = new TreeNode(2) {{
                right = new TreeNode(3);
            }};
        }};

        System.out.println(isSymmetric(t2));
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty() && !stack1.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();

            if (node1.val != node2.val) {
                return false;
            }

            if (node1.left != node2.right) {
                if (node1.left != null && node2.right != null){
                    stack1.push(node1.left);
                    stack2.push(node2.right);
                }else{
                    return false;
                }
            }

            if (node1.right != node2.left) {
                if (node1.right != null && node2.left != null){
                    stack1.push(node1.right);
                    stack2.push(node2.left);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
