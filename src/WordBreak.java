import java.util.ArrayList;
import java.util.List;

/**
 * todo 139. Word Break
 * https://leetcode.com/problems/word-break/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
    public static void main(String[] args) {
//        System.out.println(wordBreak("applepenapple", new ArrayList<String>() {{
//            add("apple");
//            add("pen");
//        }}));
        System.out.println(wordBreak("catsandog", new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }}));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        for(int i = 1; i <= s.length(); i++){
            // 循环每个字典词
            for(String str: wordDict){
                if(str.length() <= i){
                    // 只有前面的index为止的单词能从字典里找到，下一个才有可能符合
                    if(f[i - str.length()]){
                        // 截取以index为止，与字典词长度相等的字符串，与字典词比较
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        //Second DP
        /*
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        */

        return f[s.length()];
    }

}
