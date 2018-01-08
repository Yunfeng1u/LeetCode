import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of
 * both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        Log.d(findAnagrams("cbaebabacd", "abc"));
        Log.d(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] charArrayP = p.toCharArray();
        int product = product(charArrayP);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char[] toBeCompared = s.substring(i, p.length() + i).toCharArray();
            if (product(toBeCompared) == product) {
                list.add(i);
            }
        }
        return list;
    }

    public static int product(char[] chars) {
        int product = 1;
        for (char aChar : chars) {
            product *= aChar;
        }
        return product;
    }

}
