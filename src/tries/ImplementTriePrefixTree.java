package tries;

import java.util.HashMap;
import java.util.Map;
import utils.MyClass;

public class ImplementTriePrefixTree {
    
    public static class PrefixTree {

        Map<Integer, PrefixTree> children;
        boolean isEndOfWord;

        // initializes the prefix object
        public PrefixTree() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        // inserts the string word into the prefix tree
        public void insert(String word) {
            PrefixTree current = this;

            for (int i = 0; i < word.length(); i++) {
                int key = word.toLowerCase().charAt(i);
                current.children.putIfAbsent(key, new PrefixTree());
                current = current.children.get(key);
            }
            current.isEndOfWord = true;
        }

        // true if the string word is in the prefix tree, false if otherwise
        public boolean search(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            PrefixTree currentValue = this;

            for (int i = 0; i < word.length(); i++) {
                int ch = word.toLowerCase().charAt(i);

                if (!currentValue.children.containsKey(ch)) {
                    return false;
                }
                currentValue = currentValue.children.get(ch);
            }
            return currentValue.isEndOfWord;
        }

        // true if previously inserted word has prefix, false if otherwise
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) { 
                return false;
            }
            PrefixTree currentValue = this;

            for (int i = 0; i < prefix.length(); i++) {
                int firstChar = prefix.toLowerCase().charAt(i);

                if(!currentValue.children.containsKey(firstChar)) {
                    return false;
                }
                currentValue = currentValue.children.get(firstChar);
            }
            return true;
        }
    }
    public static void main(String[] agrs) {
        PrefixTree trie = new PrefixTree();
        trie.insert("dog");
        trie.insert("cat");
        MyClass.log("Inserted 'dog' and 'cat'");

        boolean hasDog = trie.search("dog");
        boolean hasCat = trie.search("cat");
        MyClass.log("Has Dog: " + hasDog);
        MyClass.log("Has Cat: " + hasCat);

        boolean hasPrefixDo = trie.startsWith("do");
        boolean hasPrefixCa = trie.startsWith("ca");
        boolean hasPrefixX = trie.startsWith("x");
        MyClass.log("Starts with 'do': " + hasPrefixDo); 
        MyClass.log("Starts with 'ca': " + hasPrefixCa); 
        MyClass.log("Starts with 'x': " + hasPrefixX); 
    }
}
