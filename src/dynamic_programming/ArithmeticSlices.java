package dynamic_programming;

/**
 * TODO blog
 * 413. Arithmetic Slices
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10}) == 1);
        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10, 12}) == 3);
        System.out.println(numberOfArithmeticSlices(new int[]{6, 8, 10, 12, 14}) == 6);
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8, 10, 12}) == 9);
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int currentGap = A[1] - A[0];
        int currentCount = 1;

        int sum = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == currentGap) {
                currentCount++;
                if (currentCount >= 3) {
                    sum += currentCount - 2;
                }
            } else {
                currentCount = 2;
                currentGap = A[i] - A[i - 1];
            }
        }
        return sum;
    }
}
