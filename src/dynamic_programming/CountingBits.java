package dynamic_programming;

import utils.Log;

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
        // counts[i]代表中i含有几个1
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // i >> 1, 右移一位，掐去最后一位
            // counts[i >> 1]代表i掐去最后最后一位有几个1，计算结果肯定前边已经得出（理解为除以2）
            // 再看最后一位是不是1。&操作符: 只有同为1结果才为1
            counts[i] = counts[i >> 1] + (i & 1);
        }
        return counts;
    }
}
