import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 * <p>
 * https://leetcode.com/problems/reorganize-string/
 * <p>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString2("aaabcdef"));
    }

    public static String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }

        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>(map.size(), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (char c : map.keySet()) {
            pq.add(new int[]{c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

    public static String reorganizeString2(String S) {
        int[] cnt = new int[26];
        int maxFreq = 0;
        char maxChar = 'a';
        for(char c : S.toCharArray()){
            cnt[c - 'a'] += 1;
            if (cnt[c - 'a'] > maxFreq){
                maxFreq = cnt[c - 'a'];
                maxChar = c;
            }
        }

        if (maxFreq > (S.length() + 1) / 2) return "";

        char[] ans = new char[S.length()];

        // put the most freq char into the even index first
        int i = 0;
        while (cnt[maxChar - 'a'] -- > 0){
            ans[i] = maxChar;
            i += 2;
        }

        for (char c = 'a'; c <= 'z'; c ++){
            while (cnt[c - 'a']-- > 0){
                if (i >= ans.length){
                    i = 1;
                }
                ans[i] = c;
                i +=2;
            }
        }

        return new String(ans);
    }
}
