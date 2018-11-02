package list;

import entity.ListNode;

import java.util.Stack;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        ListNode head2 = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3) {{
                    next = new ListNode(4) {{
                        next = new ListNode(5);
                    }};
                }};
            }};
        }};
        ListNode node = removeNthFromEnd2(head2, 1);
        System.out.println(node);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode fast = node;
        ListNode slow = node;

        while (fast.next != null){
            if (n <= 0){
                slow = slow.next;
            }
            fast = fast.next;
            --n;
        }

        // 初始n: 2
        // slow: 1,2,3

        slow.next = slow.next.next;

        return node.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        int totalSize = stack.size();

        if (n == totalSize) {
            head = head.next;
            return head;
        }

        while (!stack.isEmpty()) {
            if (totalSize - stack.size() < n) {
                current = stack.pop();
            } else {
                stack.peek().next = current.next;
                current = stack.firstElement();
                break;
            }
        }
        return current;
    }
}
