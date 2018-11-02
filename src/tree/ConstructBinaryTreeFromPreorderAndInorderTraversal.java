package tree;

import entity.TreeNode;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * todo 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
        Log.d(node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
        return construct(0, 0, inorder.length - 1, preorder, inorder);
    }

    private static TreeNode construct(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int inIndex = inStart;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = construct(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = construct(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
