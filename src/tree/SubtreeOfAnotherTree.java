package tree;

import entity.TreeNode;

import java.util.Stack;

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and
 * node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * <p>
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3) {{
            left = new TreeNode(4) {{
                left = new TreeNode(1);
                right = new TreeNode(2);
            }};
            right = new TreeNode(5);
        }};

        TreeNode t2 = new TreeNode(4) {{
            left = new TreeNode(1);
            right = new TreeNode(2);
        }};

        TreeNode t3 = new TreeNode(3) {{
            left = new TreeNode(4) {{
                left = new TreeNode(1);
                right = new TreeNode(2) {{
                    left = new TreeNode(0);
                }};
            }};
            right = new TreeNode(5);
        }};

        isSubtree(t1, t2);
        isSubtree(t3, t2);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == s) return true;
        if (s == null || t == null) {
            return false;
        }
        Stack<TreeNode> stackS = new Stack<>();
        Stack<TreeNode> stackT = new Stack<>();
        stackS.push(s);
        stackT.push(t);

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            TreeNode nodeS = stackS.pop();
            TreeNode nodeT = stackT.pop();
            if (nodeT.val == nodeS.val) {

            }



        }
        return true;
    }
}
