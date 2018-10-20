package dynamic_programming;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
//        int[][] param = new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
        int[][] param = new int[][]{
                {1, 6, 1, 2},
                {1, 5, 3, 1},
                {5, 2, 1, 1}
        };

        System.out.println(minPathSum(param));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int min[][] = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    min[i][j] = grid[i][j];
                } else if (i == 0) {
                    min[i][j] = min[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    min[i][j] = min[i - 1][j] + grid[i][j];
                } else {
                    min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
                }
            }
        }
        return min[grid.length - 1][grid[0].length - 1];
    }
}
