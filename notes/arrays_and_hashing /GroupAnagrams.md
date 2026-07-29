Summary of Workflow:

1. Loop to grab each string in the array.
2. Convert the string into individual characters and sort them alhphabetically using ASCII numeric values.
3. Turn the sorted characters into a string key.
4. We insert the key and initialize an array list if not able to insert.
5. Fetch the keys list and drop the original word inside. 
6. Collect all lists from map and return them.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Big O(m*n) is bilinear time comp 
        // execution time depends on product of two indep. input vars 
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String s: strs) {
            // 1. convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // 2. create the uniform key
            String key = new String(chars);

            // 3. put the key in map (initialize if it doesnt exist)
            hashmap.putIfAbsent(key, new ArrayList<>());
            hashmap.get(key).add(s);
        }
        return new ArrayList<>(hashmap.values());
    }
}

To optimize:
look into removing the sort method (which takes O(MlogM)) since it slows down the code for really long words.
We could also use alphabet frequency count instead of sorting the letters to create a unique key