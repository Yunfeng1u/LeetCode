package number;

import java.util.List;

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 * <p>
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 2^31.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistanceS(56,612));
    }

    public static int hammingDistance(int x, int y) {
        int countDiff = 0;
        String binaryStringHigh = Integer.toBinaryString(x);
        String binaryStringLow = Integer.toBinaryString(y);

        int gap = binaryStringHigh.length() - binaryStringLow.length();

        if (gap < 0) {
            gap = -gap;
            String temp = binaryStringHigh;
            binaryStringHigh = binaryStringLow;
            binaryStringLow = temp;
        }

        for (int i = binaryStringLow.length() - 1; i >= 0; i--) {
            if (binaryStringHigh.charAt(i + gap) != binaryStringLow.charAt(i)) {
                countDiff++;
            }
        }

        for (int i = 0; i < gap; i++) {
            if (binaryStringHigh.charAt(i) == '1') {
                countDiff++;
            }
        }
        return countDiff;
    }

    public static int hammingDistanceS(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
