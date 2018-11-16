package dynamic_programming;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
        System.out.println(minimumDeleteSum("sea", "eat"));
    }

    public static int minimumDeleteSum(String s1, String s2) {

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + a1[i - 1];
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + a2[i - 1];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a1[i - 1] == a2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + a1[i - 1],
                            dp[i][j - 1] + a2[j - 1]
                    );
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
