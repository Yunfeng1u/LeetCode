package list;

import entity.ListNode;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2) {{
            next = new ListNode(4) {{
                next = new ListNode(7);
            }};
        }};

        ListNode l2 = new ListNode(5) {{
            next = new ListNode(6) {{
                next = new ListNode(4);
            }};
        }};

        ListNode res = addTwoNumbers(l1, l2);

        System.out.println(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode current = new ListNode(0);

        ListNode head = current;

        int extra = 0;

        while (l1 != null || l2 != null || extra > 0) {

            ListNode node = new ListNode(0);

            if (l1 != null) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            }

            node.val += extra;

            extra = node.val / 10;
            node.val = node.val % 10;

            current.next = node;
            current = current.next;
        }

        return head.next;
    }
}
