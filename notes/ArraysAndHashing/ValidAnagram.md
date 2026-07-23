For this, we begin by creating two hashmaps of type <Character, Integer> that we will later use to check the s and t string for angrams. The base case here is to check if string s and t are both of equal length, otherwise it would be impossible for them to be anagrams.

We then create two for loops to check each string, but could be simplified to one later. I tried to use an if statement in each loop to check if the hashmap did not contain a ket at the index of char at i/j, then we would add it. This was done by using the getOrDefault method for both. Given that getOrDefault attemps to retrieve the current count of a letter, and pretends that it's 0 if there is no current count, we can remove it outright since it handles the missing case (returns 0) and the 'already exists' case (returns the actual count). Therefore, we do not need the if statement to check containsKey at all.

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashmap1 = new HashMap<>();
        HashMap<Character, Integer> hashmap2 = new HashMap<>();
        // if they are not equal in length, they cannot possibly be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            hashmap1.put(s.charAt(i), hashmap1.getOrDefault(s.charAt(i), 0) + 1);
            
        }
        for (int j = 0; j < t.length(); j++) {
            hashmap2.put(t.charAt(j), hashmap2.getOrDefault(t.charAt(j), 0) + 1);
        }

        // modify this so that we're not using == since it checks address not value
          if (hashmap1 != null && hashmap2 != null) {
            return hashmap1.equals(hashmap2);
        } 
        return false;
    }
}

so this works and is straight forward. To optimize: 

remove the null check. not needed since we initiaze both maps to the heap using new. 

We could also combine the hashmaps into 1 to save memory or use a primative array to make it run faster.

Summary:
This optimal solution leverages a fixed-size integer array to track character frequencies in \(O(N)\) time and \(O(1)\) constant space, bypassing the heavy heap allocation overhead of a HashMap [NeetCode]. After verifying that both strings are identical in length, the algorithm utilizes a character subtraction math trick (charAt(i) - 'a') to map lowercase letters directly to array indices based on their underlying ASCII values. It increments frequencies while iterating through the first string to establish a character "credit," and subsequently decrements those frequencies while parsing the second string [NeetCode]. By checking the array state on the fly, any drop below zero instantly flags an extra or mismatched character, enabling an early-exit return false that optimizes runtime and inherently guards against ArrayIndexOutOfBoundsException bugs.