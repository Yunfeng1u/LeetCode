package permutation;

import utils.Log;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Log.d(letterCombinations2("23"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return list;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>() {{
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};

        char[] numbers = digits.toCharArray();

        for (char number : numbers) {
            char[] chars = map.get(number);
            list = multiply(list, chars);
        }

        return list;
    }

    private static List<String> multiply(List<String> origin, char[] chars) {
        if (origin.isEmpty()) {
            for (char aChar : chars) {
                origin.add(String.valueOf(aChar));
            }
            return origin;
        } else {
            List<String> newOne = new ArrayList<>(origin.size() * chars.length);
            for (String s : origin) {
                for (char aChar : chars) {
                    newOne.add(s + aChar);
                }
            }
            return newOne;
        }
    }

    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
