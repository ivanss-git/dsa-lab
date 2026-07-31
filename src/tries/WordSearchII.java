package tries;
import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class Solution {

        private final TrieNode root = new TrieNode();

        private static class TrieNode {
            private final TrieNode[] children = new TrieNode[26];
            private String word;
        }

        private void addWord(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }

        private void match(
            char[][] board,
            int row,
            int col,
            TrieNode curr,
            List<String> result
        ) {
            if (row < 0 || row >= board.length ||
                col < 0 || col >= board[row].length ||
                board[row][col] == '#') {
                return;
            }

            char ch = board[row][col];
            int index = ch - 'a';
            TrieNode next = curr.children[index];

            if (next == null) {
                return;
            }

            if (next.word != null) {
                result.add(next.word);
                next.word = null; // Prevent duplicate results
            }

            board[row][col] = '#';

            match(board, row + 1, col, next, result);
            match(board, row - 1, col, next, result);
            match(board, row, col + 1, next, result);
            match(board, row, col - 1, next, result);

            board[row][col] = ch; // Backtrack
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> result = new ArrayList<>();

            if (board == null || board.length == 0 ||
                words == null || words.length == 0) {
                return result;
            }

            for (String word : words) {
                addWord(word);
            }

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    match(board, row, col, root, result);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

    }
}
