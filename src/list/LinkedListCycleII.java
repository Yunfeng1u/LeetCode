package list;

import entity.ListNode;
import utils.Log;

import java.util.Locale;

/**
 * 142. Linked List Cycle II
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {

        final ListNode node3 = new ListNode(3) {{
            next = new ListNode(4) {{
                next = new ListNode(5);
            }};
        }};

        ListNode head = new ListNode(1) {{
            next = new ListNode(2) {{
                next = node3;
            }};
        }};

        node3.next.next.next = node3;

        ListNode res = detectCycle(head);

        Log.d(res.val);

    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        do {
            tortoise = tortoise.next;
            if (tortoise == null){
                return null;
            }

            if (hare.next == null){
                return null;
            }

            hare = hare.next.next;

            if (hare == null){
                return null;
            }

        }while (tortoise != hare);

        ListNode ptr1 = head;
        ListNode ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}
