package tries;

import java.util.ArrayList;
import java.util.List;
import utils.MyClass;

public class AddAndSearchWord {

    public static class WordDictionary {
        WordDictionary[] children = new WordDictionary[26];
        boolean isEndOfWord = false;

        // The object itself acts as the root node.
        public WordDictionary() {
        }

        public void addWord(String word) {
            WordDictionary curr = this; 
            for (char c : word.toLowerCase().toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new WordDictionary();
                }
                curr = curr.children[i];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            return match(word, this, 0);
        }

        private boolean match(String word, WordDictionary curr, int index) {
            if (curr == null) {
                return false;
            }
            if (index == word.length()) {
                return curr.isEndOfWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (WordDictionary child : curr.children) {
                    if (child != null && match(word, child, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
            int i = c - 'a';
            if (i < 0 || i >= 26) {
                return false;
            }
            return match(word, curr.children[i], index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> output = new ArrayList<>();
        WordDictionary wd = null;

        String[] commands = {"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"};
        
        String[] arguments = {"", "day", "bay", "may", "say", "day", ".ay", "b.."};

        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];
            String arg = arguments[i];

            if (cmd.equals("WordDictionary")) {
                wd = new WordDictionary();
                output.add(null); // Constructor returns nothing
            } else if (cmd.equals("addWord")) {
                wd.addWord(arg);
                output.add(null); // addWord returns void, so track null automatically
            } else if (cmd.equals("search")) {
                boolean result = wd.search(arg);
                output.add(String.valueOf(result)); // Track actual boolean outcome
            }
        }

        MyClass.log(output);
    }  
}
