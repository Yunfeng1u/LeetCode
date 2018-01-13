import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        Log.d(countSubstrings("abcba") == 7);
        Log.d(countSubstrings("abbba") == 9);
        Log.d(countSubstrings("ababa") == 9);
        Log.d(countSubstrings("aaa") == 6);
        Log.d(countSubstrings("abbbx") == 8);
    }

    public static int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {

            int effect = 0;

            for (int j = 0; j < i; j++) {
                if (i - j >= 1) {
                    String effectString = s.substring(j, i + 1);
//                    System.out.println("s = " + j + ", e = " + i + ", val = " + effectString);
                    if (isPalindromic(effectString)) {
                        effect++;
                    }
                }
            }
            dp[i] = dp[i - 1] + effect + 1;
//            System.out.println();
        }

//        System.out.println("result = " + dp[s.length() - 1]);
        return dp[s.length() - 1];
    }

    public static boolean isPalindromic(String value) {

        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
