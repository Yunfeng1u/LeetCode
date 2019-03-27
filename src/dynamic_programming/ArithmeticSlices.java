package dynamic_programming;

/**
 * TODO blog
 * 413. Arithmetic Slices
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
//        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10}) == 1);
//        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10, 12}) == 3);
//        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10, 12, 14}) == 6);
//        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10, 12, 14, 16}) == 10);
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8, 10, 12}) == 9);
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int offset = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            int num = A[i];
            int left1 = A[i - 1];
            int left2 = A[i - 2];
            if (num - left1 == left1 - left2) {
                offset += 1;
                // 每次引入一个新的数，能与它组成新的数组的数量为offset
                sum += offset;
            } else {
                offset = 0;
            }
        }
        return sum;
    }
}
