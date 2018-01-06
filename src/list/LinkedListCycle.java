package list;

import entity.ListNode;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 */
public class LinkedListCycle {
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

        ListNode head2 = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3) {{
                    next = new ListNode(4) {{
                        next = new ListNode(5);
                    }};
                }};
            }};
        }};


        System.out.println(hasCycle(head2));
    }

    public static boolean hasCycle(ListNode head) {

        ListNode cur1 = head;
        ListNode cur2 = head;

        while (cur1 != null && cur2 != null) {
            cur1 = cur1.next;

            if (cur1 == null) {
                return false;
            }

            if (cur2.next == null) {
                return false;
            }

            cur2 = cur2.next.next;
            if (cur2 == null) {
                return false;
            }

            if (cur1 == cur2) {
                return true;
            }
        }

        return false;
    }
}
