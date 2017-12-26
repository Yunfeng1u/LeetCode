package number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 * https://leetcode.com/problems/self-dividing-numbers/description/
 * <p>
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 * <p>
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * <p>
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(1, 37);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();
        for (int current = left; current <= right; current++) {
            int j = current;
            while(j > 0){
                int digit = j % 10;
                if (digit == 0 || (current % (digit) != 0)) {
                    break;
                }
                j /= 10;
            }
            if (j == 0) list.add(current);
        }
        return list;
    }
}
