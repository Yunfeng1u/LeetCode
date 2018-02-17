package matrix;

import utils.Log;

/**
 * 240. Search a 2D Matrix II
 * <p>
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 28, 30},
        };

        Log.d(searchMatrix(matrix, 26));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        return find(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private static boolean find(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd, int target) {

        if (rowEnd < 0 || columnEnd < 0) return false;

        if (rowStart >= matrix.length || columnStart >= matrix[0].length) return false;

        if (rowStart > rowEnd || columnStart > columnEnd) return false;

        int rowIndex = (rowEnd + rowStart) / 2 + (rowEnd + rowStart) % 2;
        int columnIndex = (columnEnd + columnStart) / 2 + (columnEnd + columnStart) % 2;

        int center = matrix[rowIndex][columnIndex];

        if (rowStart == rowEnd && columnStart == columnEnd) {
            return center == target;
        }

        if (center == target) {
            return true;
        } else if (center < target) {
            return find(matrix, rowIndex + 1, rowEnd, columnStart, columnEnd, target)
                    || find(matrix, rowStart, rowIndex, columnIndex + 1, columnEnd, target);
        } else {
            return find(matrix, rowStart, rowEnd, columnStart, columnIndex - 1, target)
                    || find(matrix, rowStart, rowIndex - 1, columnIndex, columnEnd, target);
        }
    }
}
