package tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally
 * identical and the nodes have the same value.
 * <p>
 * Example 1:
 * <p>
 * Input:
 *   1         1
 *  / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * Input:
 *   1         1
 *  /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * Example 3:
 * <p>
 * Input:
 *   1         1
 *  / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 */
public class SameTree {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1) {{
            left = new TreeNode(3) {{
                left = new TreeNode(5);
            }};
        }};

        TreeNode t2 = new TreeNode(1) {{
            right = new TreeNode(3) {{
                left = new TreeNode(5);
            }};
        }};

        System.out.println(isSameTree(t1, t2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == q) return true;

        if (p == null || q == null) return false;

        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() || !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            if (nodeP.val != nodeQ.val) {
                return false;
            }

            if (nodeP.left != nodeQ.left) {
                if (nodeP.left == null || nodeQ.left == null) {
                    return false;
                } else {
                    queueP.offer(nodeP.left);
                    queueQ.offer(nodeQ.left);
                }
            }

            if (nodeP.right != nodeQ.right) {
                if (nodeP.right == null || nodeQ.right == null) {
                    return false;
                } else {
                    queueP.offer(nodeP.right);
                    queueQ.offer(nodeQ.right);
                }
            }
        }

        return true;
    }
}
