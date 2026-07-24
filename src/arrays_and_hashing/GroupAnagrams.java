package arrays_and_hashing;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {
    public List<List<String>> Solution (String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();

        for (String s : strs) {
            // 1. convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // 2. create the uniform key
            String key = new String(chars);

            // 3. put it in the map (initialize list if it doesn't exist)
            hashmap.putIfAbsent(key, new ArrayList<>());
            hashmap.get(key).add(s);
        }

    // 4. return all the grouped lists
    return new ArrayList<>(hashmap.values());

    }
    
    public static void main (String[] args) {
        String[] strs = {"cat", "elloh", "tac", "elloh"};
        GroupAnagrams ga = new GroupAnagrams();
        System.out.printf("Grouped Anagrams: %s", ga.Solution(strs));

   }
}
