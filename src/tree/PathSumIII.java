package tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(10) {{
            left = new TreeNode(5) {{
                left = new TreeNode(3){{
                    left = new TreeNode(3);
                    right = new TreeNode(-2);
                }};
                right = new TreeNode(2){{
                    right = new TreeNode(1);
                }};
            }};
            right = new TreeNode(-3) {{
                right = new TreeNode(11);
            }};
        }};
        System.out.println(pathSum(t1, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int paths = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
        }

        return 0;
    }
}
