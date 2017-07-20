public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) return false;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] && search(board, i, j, word))
                    return true;
            }
        }
        return true;
    }

    public static search(char[][] board, int i, int j, word) {
        int row = board.length;
        int col = board[0].length;

        int k = 0;
        int len = word.length();
        for (char c = word.charAt(k); k < len; k++) {
            
        }

    }
}
