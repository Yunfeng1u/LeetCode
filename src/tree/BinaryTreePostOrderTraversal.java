package tree;

import entity.TreeNode;
import utils.Log;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * 　\
 * 　　2
 * 　/
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostOrderTraversal {
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

        Log.d(postOrderTraversal(t1));
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null){
                stack.push(current);
                list.add(0, current.val);
                current = current.right;
            }else {
                current = stack.pop().left;
            }
        }
        return list;
    }
}
