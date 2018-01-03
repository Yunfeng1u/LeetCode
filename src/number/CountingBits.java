package number;

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
        int[] result = countBits(51);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
            if ((i+1) % 4 == 0){
                System.out.println();
            }
        }
    }

    public static int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            counts[i] = Integer.bitCount(i);
            System.out.println(i + " -> " + counts[i]);
        }
        return counts;
    }

    public int[] twoSumSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
