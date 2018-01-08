package list;

import entity.ListNode;
import utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 160. Intersection of Two Linked Lists
 * <p>
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:  　　a1 → a2
 * 　　　　　　　　　↘
 * 　　　　　　　　   c1 → c2 → c3
 * 　　　　　　　　　↗
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

        final ListNode headC = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3);
            }};
        }};

        ListNode headA = new ListNode(4) {{
            next = new ListNode(5) {{
                next = new ListNode(6) {{
                    next = headC;
                }};
            }};
        }};

        ListNode headB = new ListNode(7) {{
            next = new ListNode(8) {{
                next = headC;
            }};
        }};


        Log.d(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        HashMap<ListNode, Integer> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, 1);
            headA = headA.next;
        }

        while (headB != null) {
            Integer count = map.get(headB);
            if (count != null) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeS(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
