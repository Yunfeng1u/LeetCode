package matrix;

import utils.Log;

/**
 * 74. Search a 2D Matrix
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        Log.d(searchMatrix(matrix, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;

        while (rowIndex < matrix.length && columnIndex >= 0) {
            int number = matrix[rowIndex][columnIndex];
            if (number == target){
                return true;
            }else if (number < target){
                rowIndex++;
            }else {
                columnIndex--;
            }
        }
        return false;
    }
}
