package matrix;

import com.sun.tools.javac.util.Pair;
import utils.Log;

import java.util.*;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        char[][] grid2 = new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '1', '1', '1'},
        };
        char[][] grid3 = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
        };
        char[][] grid4 = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        long time1 = System.currentTimeMillis();
        Log.d(numIslands(grid1));
        long t2 = System.currentTimeMillis() - time1;
        System.out.println(t2);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    walk(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void walk(char[][] grid, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] currentPosition = stack.peek();
            int currentI = currentPosition[0];
            int currentJ = currentPosition[1];

            grid[currentI][currentJ] = '0';

            if (currentI > 0 && grid[currentI - 1][currentJ] == '1') {
                stack.push(new int[]{currentI - 1, currentJ});
                continue;
            }

            if (currentJ > 0 && grid[currentI][currentJ - 1] == '1') {
                stack.push(new int[]{currentI, currentJ - 1});
                continue;
            }

            if (grid.length > currentI + 1 && grid[currentI + 1][currentJ] == '1') {
                stack.push(new int[]{currentI + 1, currentJ});
                continue;
            }

            if (grid[0].length > currentJ + 1 && grid[currentI][currentJ + 1] == '1') {
                stack.push(new int[]{currentI, currentJ + 1});
                continue;
            }

            stack.pop();
        }
    }
}
