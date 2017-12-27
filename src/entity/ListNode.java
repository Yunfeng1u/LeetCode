package entity;

/**
 * Created by luyunfeng on 2017/12/27.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(val));
        ListNode temp = next;
        while (temp != null) {
            stringBuilder.append(", ").append(temp.val);
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}
