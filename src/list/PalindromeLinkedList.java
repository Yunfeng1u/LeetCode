package list;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

        ListNode head2 = new ListNode(1) {{
            next = new ListNode(2) {{
                next = new ListNode(3) {{
                    next = new ListNode(3) {{
                        next = new ListNode(2) {{
                            next = new ListNode(1);
                        }};
                    }};
                }};
            }};
        }};

        System.out.println(isPalindrome(head2));
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).compareTo(list.get(size - 1 - i)) != 0) {
                return false;
            }
        }
        return true;
    }
}
