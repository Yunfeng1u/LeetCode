package utils;

import entity.ListNode;

/**
 * Created by luyunfeng on 2017/12/25.
 */
public class Log {
    public static void d(Object object) {
        if (object == null) {
            System.out.println("NULL");
        } else {
            System.out.println(object);
        }
    }

    public static void d(int[] ints) {
        if (ints == null) {
            System.out.println("NULL ARRAY");
        } else {
            for (int object : ints) {
                System.out.print(object + ", ");
            }
            System.out.println();
        }
    }

    public static void d(Object[] objects) {
        if (objects == null) {
            System.out.println("NULL ARRAY");
        } else {
            for (Object object : objects) {
                System.out.print(object + ", ");
            }
            System.out.println();
        }
    }

    public static void d(ListNode listNode) {
        if (listNode == null) {
            System.out.println("NULL LIST");
        } else {
            while (listNode != null){
                System.out.print(listNode.val + ", ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }
}
