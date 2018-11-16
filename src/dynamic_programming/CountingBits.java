package dynamic_programming;

import sun.jvm.hotspot.utilities.Assert;
import utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 */
public class CountingBits {
    public static void main(String[] args) {
        int[] result = countBits(128);
        Log.d(result);
    }

    public static int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            counts[i] = counts[i >> 1] + (i & 1);
        }
        return counts;
    }
}
