package string;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring4("abba"));
        System.out.println(lengthOfLongestSubstring4("abcaef"));
        System.out.println(lengthOfLongestSubstring4("abcbef"));
        System.out.println(lengthOfLongestSubstring4("bbbbb"));
        System.out.println(lengthOfLongestSubstring4("pwwkew"));
        System.out.println(lengthOfLongestSubstring4("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = list.indexOf(c);
            if (index >= 0) {
                // remove elements before and in `index`
                for (int j = 0; j <= index; j++) {
                    list.remove(0);
                }
            }

            list.add(c);

            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                j = Math.max(j, index + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() < 1) return 0;
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int res = 0;
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, map[s.charAt(i)]);
            res = Math.max(res, i - pre);
            map[s.charAt(i)] = i;
        }
        return res;
    }

    public static int lengthOfLongestSubstring5(String s) {
        int ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}
