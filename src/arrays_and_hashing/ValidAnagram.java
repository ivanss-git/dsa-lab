package arrays_and_hashing;
// import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // This works but it would be best to optimize:
        // we could use a single hashmap, primitive array using the math trick for ASCII's underlying numbers 
        // The arithmetic works in c/c++/java because chars are actually stored in small int value

        // HashMap<Character, Integer> hashmap1 = new HashMap<>();
        // HashMap<Character, Integer> hashmap2 = new HashMap<>();

        // // Base case: cannot possibly be anagrams if their length is different
        // if (s.length() != t.length()) {
        //     return false;
        // }
        // // if else not needed because the getOrDefault method handles both cases
        // for (int i = 0; i < s.length(); i++) {
        //     // attemps to add the value into the hash map
        //     // if empty, defaults to 0, increases count by 1, and adds it.
        //     hashmap1.put(s.charAt(i), hashmap1.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // for (int j = 0; j < t.length(); j++) {
        //     hashmap2.put(t.charAt(j), hashmap2.getOrDefault(t.charAt(j), 0) + 1);
        // }

        // // can later optimize to remove null check since not needed bc the hashmap is initialized upon creation
        // // meaning we can directly return the boolean of both hashmaps using the .equals method
        // // we don't use == because that checks their memory address, not value.
        // if (hashmap1 != null && hashmap2 != null) {
        //     return hashmap1.equals(hashmap2);
        // }
        // return false;


        // base case
        if (s.length() != t.length()) {
            return false;
        }

        //fixed space allocation
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
            // better to save calculation to a variable to avoid the computer from doing the same math twice
            int index = t.charAt(i) - 'a';
            // don't do charCounts[i] < 0 bc for ex, l in hello is at index 1
            // meaning that charCounts[i] checks 1, not charCounts[11] from t.charAt(1) - 'a' the way it should
            // Since 0 < 0 is false, it'll assume everything is fine and keep looking
            // OOB exception if user enters two 50 char strings since > 26

            if (charCounts[index] < 0) {
                return false;
            }     
        }
        return true;

        // ^ is the primitive array approach - optimal solution for time and space complexity
    }
    public static void main(String [] args) {
        ValidAnagram va = new ValidAnagram();
        String one = "hello";
        // String two = "yello";
        String three = "elloh";
        // formatted string to keep clean and avoid messy string concatenation 
        System.out.printf("String %s and String %s are anagrams: %b%n ", one, three, va.isAnagram(one, three));
    }
}
