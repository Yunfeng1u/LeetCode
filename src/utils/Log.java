package utils;

import entity.ListNode;

import java.util.List;

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

    public static void d(double[] doubles) {
        if (doubles == null) {
            System.out.println("NULL ARRAY");
        } else {
            for (double d : doubles) {
                System.out.print(d + ", ");
            }
            System.out.println();
        }
    }

    public static void d(int[][] matrix) {
        if (matrix == null) {
            System.out.println("NULL MATRIX");
        } else {
            for (int[] ints : matrix) {
                d(ints);
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
            while (listNode != null) {
                System.out.print(listNode.val + ", ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }

    public static void d(List list) {
        if (list == null) {
            System.out.println("NULL LIST");
        } else {
            for (Object object : list) {
                if (object instanceof List) {
                    d((List) object);
                } else {
                    System.out.print(object + ", ");
                }
            }
            System.out.println();
        }
    }
}
