public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) return false;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exists(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean exists(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) return false;
        if (board[i][j] != word.charAt(k)) return false;

        board[i][j] ^= 256;
        boolean exists = exists(board, i, j+1, word, k+1)
            || exists(board, i, j-1, word, k+1)
            || exists(board, i+1, j, word, k+1)
            || exists(board, i-1, j, word, k+1);
        board[i][j] ^= 256;
        return exists;
    }
}
