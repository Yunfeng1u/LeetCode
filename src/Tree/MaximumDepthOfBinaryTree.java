package Tree;

import entity.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        TreeNode t = new TreeNode(2) {{
            left = new TreeNode(1) {{
                right = new TreeNode(4);
            }};
            right = new TreeNode(3) {{
                right = new TreeNode(7){{
                    left = new TreeNode(1) {{
                        right = new TreeNode(4);
                    }};
                }};
            }};
        }};

        int result = maxDepth(t);
        System.out.println(result);
    }

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return depth;
    }
}
