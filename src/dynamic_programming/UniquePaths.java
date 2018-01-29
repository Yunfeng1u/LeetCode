package dynamic_programming;

/**
 * 62. Unique Paths
 * <p>
 * https://leetcode.com/problems/unique-paths/description/
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
    }

    public static int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) return 0;

        if (m == 1 || n == 1) return 1;

        if (m > n){
            m ^= n;
            n ^= m;
            m ^= n;
        }

        int[][] dp = new int[m + 1][n + 1];

        dp[1][2] = 1;
        dp[2][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                if (i == 1 || j == 1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
                if (dp.length > j && dp[j].length > i){
                    dp[j][i] = dp[i][j];
                }
            }
        }

        return dp[m][n];
    }

}
