package matrix;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        char[][] board2 = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'},
        };

        char[][] board3 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        System.out.println(exist(board3, "ABCESEEEFS"));
//        System.out.println(exist(board2, "AAB"));
//        System.out.println(exist(board, "ABCCED"));
//        System.out.println(exist(board, "SEE"));
//        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findWord(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findWord(char[][] board, char[] wordArray, int i, int j, int index) {
        if (index >= wordArray.length
                || i >= board.length || i < 0
                || j >= board[0].length || j < 0) {
            return false;
        }

        if (board[i][j] == wordArray[index]) {
            if (index == wordArray.length - 1) {
                return true;
            }
            board[i][j] ^= 256;
            index++;

            boolean exists = findWord(board, wordArray, i - 1, j, index)
                    || findWord(board, wordArray, i, j - 1, index)
                    || findWord(board, wordArray, i + 1, j, index)
                    || findWord(board, wordArray, i, j + 1, index);

            board[i][j] ^= 256;
            return exists;
        }
        return false;
    }
}
