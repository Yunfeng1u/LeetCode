package list;

import entity.ListNode;
import utils.Log;

/**
 * TODO 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(4);
            }};
        }};

        ListNode l2 = new ListNode(1) {{
            next = new ListNode(3) {{
                next = new ListNode(4);
            }};
        }};

        Log.d(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = null;
        ListNode current = null;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 == null) {
                temp = l1;
                l1 = l1.next;
            } else if (l1 == null) {
                temp = l2;
                l2 = l2.next;
            } else {
                if (l1.val < l2.val) {
                    temp = l1;
                    l1 = l1.next;
                } else {
                    temp = l2;
                    l2 = l2.next;
                }
            }

            if (current == null){
                current = temp;
            }else{
                current.next = temp;
                current = current.next;
            }
        }

        return current;
    }

    public static ListNode addNode(ListNode listNode, int val) {
        if (listNode == null) {
            listNode = new ListNode(val);
        } else {
            listNode.next = new ListNode(val);
        }
        return listNode;
    }
}
