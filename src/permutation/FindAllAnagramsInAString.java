package permutation;

import com.sun.deploy.util.StringUtils;
import utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
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
        Log.d(findAnagrams3("cbaebabacd", "abc"));
        Log.d(findAnagrams3("abab", "ab"));
    }

    public static List<Integer> findAnagrams3(String s, String p) {

        char[] ptrn = p.toCharArray();
        char[] str = s.toCharArray();

        int[] w = new int[26];

        for(char c : ptrn) w[c - 'a']++;

        int start = 0;

        List<Integer> result = new LinkedList<>();

        for(int i = 0; i<str.length; i++){
            int cIndex = str[i] - 'a';

            w[cIndex]--;
            // the crucial bit, if we have seen the character too many times
            // or it is a character that is not in the pattern, rewind the starting index
            while(w[cIndex] < 0){
                w[str[start] - 'a']++;
                start++;
            }

            if(i - start + 1 == ptrn.length){
                result.add(start);
                w[str[start] - 'a']++;
                start++;
            }
        }


        return result;
    }
}
