package tree;

import entity.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        TreeNode t = new TreeNode(2) {{
            left = new TreeNode(1) {{
                right = new TreeNode(4);
            }};
            right = new TreeNode(3) {{
                right = new TreeNode(7) {{
                    left = new TreeNode(1) {{
                        right = new TreeNode(4);
                    }};
                }};
            }};
        }};

        int result = diameterOfBinaryTree(t);
        System.out.println(result);
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        return 0;
    }
}
