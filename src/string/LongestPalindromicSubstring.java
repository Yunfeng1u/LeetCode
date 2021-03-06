package string;

import utils.Log;

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
//        System.out.println(longestPalindrome("aba").equals("aba"));
//        System.out.println(longestPalindrome("babab").equals("babab"));
//        System.out.println(longestPalindrome("bbcbcbb").equals("bbcbcbb"));
        System.out.println(longestPalindrome("bccb").equals("bccb"));
//        System.out.println(longestPalindrome("babad").equals("bab"));
//        System.out.println(longestPalindrome("cbbd").equals("bb"));
//        System.out.println(longestPalindrome("abcda").equals("a"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
