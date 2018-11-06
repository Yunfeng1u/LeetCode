package matrix;

/**
 * todo 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class MaximalSquare {

    public static void main(String[] args) {

        char[][] matrix1 = new char[][]{
                {'1', '1', '1', '1'},
                {'1', '0', '0', '1'},
                {'1', '1', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
        };

        System.out.println(maximalSquare(matrix1));

        char[][] matrix2 = new char[][]{
                {'1', '1'},
                {'1', '1'},
        };

        System.out.println(maximalSquare(matrix2));

        char[][] matrix3 = new char[][]{
                {'0', '1'},
        };

        System.out.println(maximalSquare(matrix3));

        char[][] matrix4 = new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
        };

        System.out.println(maximalSquare(matrix4));
    }

    public static int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int max = 0, n = matrix.length, m = matrix[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // return the area
        return max * max;
    }
}
