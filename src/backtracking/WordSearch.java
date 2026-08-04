package backtracking;

import utils.MyClass;

public class WordSearch {

    private int ROWS, COLS;
    private boolean[][] visited;

    private boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        if (board == null || word == null ||
            board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) || visited[r][c]) {
            return false;
        }
        
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                    dfs(board, word, r - 1, c, i + 1) ||
                    dfs(board, word, r, c + 1, i + 1) ||
                    dfs(board, word, r, c - 1, i + 1);

        visited[r][c] = false;

        return res;
        
    }
    public static void main(String[] args) { 
        WordSearch ws = new WordSearch(); 
        
        char[][] board = { 
            {'A','B','C','D'}, 
            {'S','A','A','T'}, 
            {'A','C','A','E'} 
        }; 
        
        String word = "CAT"; 
        boolean output = ws.exist(board, word); 

        MyClass.log("Output: " + output); 
    }

}
