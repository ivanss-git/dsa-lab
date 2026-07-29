package tries;

import java.util.HashMap;
import java.util.Map;
import utils.MyClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // 1. Initialize the List to hold the string results
        List<String> output = new ArrayList<>();
        
        // 2. Execute the LeetCode sequence exactly
        PrefixTree prefixTree = new PrefixTree();
        output.add("null"); // Creating the tree returns void/null

        prefixTree.insert("dog");
        output.add("null"); // insert returns void/null

        output.add(String.valueOf(prefixTree.search("dog")));  
        output.add(String.valueOf(prefixTree.search("do")));    
        output.add(String.valueOf(prefixTree.startsWith("do"))); 

        prefixTree.insert("do");
        output.add("null"); 

        output.add(String.valueOf(prefixTree.search("do")));     

        // 3. Convert the List to a final String Array
        String[] finalArray = output.toArray(new String[0]);

        // 4. Print the final array formatted exactly like the expected Output
        MyClass.log(Arrays.toString(finalArray));
    }
}
