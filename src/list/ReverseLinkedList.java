package list;

import entity.ListNode;
import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * <p>
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3) {{
                    next = new ListNode(4) {{
                        next = new ListNode(5);
                    }};
                }};
            }};
        }};

        System.out.println(reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // nextTemp = 2
            ListNode nextTemp = curr.next;
            // 1 -> null
            curr.next = prev;
            // prev = 1
            prev = curr;
            // curr = 2
            curr = nextTemp;
        }
        return prev;
    }
}
