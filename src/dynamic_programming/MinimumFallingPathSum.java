package dynamic_programming;

import utils.Log;

/**
 * TODO blog
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum
 */
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Log.d(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] A) {

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int from = A[i - 1][j];
                if (j > 0) {
                    from = Math.min(A[i - 1][j - 1], from);
                }
                if (j < A[0].length - 1) {
                    from = Math.min(A[i - 1][j + 1], from);
                }
                A[i][j] = A[i][j] + from;
            }
        }

        int[] lastRow = A[A.length - 1];

        int min = lastRow[0];

        for (int i = 1; i < lastRow.length; i++) {
            if (min > lastRow[i]){
                min = lastRow[i];
            }
        }
        return min;
    }
}
