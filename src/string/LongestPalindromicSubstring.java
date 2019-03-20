package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba").equals("aba"));
        System.out.println(longestPalindrome("babab").equals("babab"));
        System.out.println(longestPalindrome("bbcbcbb").equals("bbcbcbb"));
        System.out.println(longestPalindrome("bccb").equals("bccb"));
        System.out.println(longestPalindrome("babad").equals("bab"));
        System.out.println(longestPalindrome("cbbd").equals("bb"));
        System.out.println(longestPalindrome("abcda").equals("a"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String ans = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ans.length() >= i + 1 - j) {
                    continue;
                }
                if (isPalindrome(s, j, i)) {
                    String current = s.substring(j, i + 1);
                    if (ans.length() < current.length()) {
                        ans = current;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            if (s.charAt(i) != s.charAt(end  - i + start)) {
                return false;
            }
        }
        return true;
    }
}
