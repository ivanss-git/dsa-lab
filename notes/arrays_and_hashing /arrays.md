1. What are arrays?
A data structure that contains multiple values of the same type.

2. What problem do they solve?
The ability to index an array allow us to locate or find values at a specifix position in the array. This solves the problem of organizing and managing multiple related variables without creating endless individual varibales.

3. What tradeoffs do arrays make?
The main tradeoff is that all elements need to be of the same data type. Additionally, the size of the array must be specified once created and cannot be resized in languages like c/c++ or java.

4. How are arrays laid out in memory?
Arrays are contiguous memory (stored sequentially in adjacent memory locations), which allows for fast access since they use parallel arithmetic without traversing the entire dataset.

If declared inside the function, the array is stored on the stack (static). If the array is declared using malloc in c or new in java, it is stored on the heap (dynamic). 

5. What operations are fast/slow and why? 
For Starters, note that java arrays have native and non-native operations. The native operations include read (array[i]), and update (array[i] = ..), which overrides the existing value, and check length (.length).

As for the non-native operations, they include: insert/delete, which is done by creating a new array -> copying the existing elements into the new array -> delete the old array. We also have search/sort through, which use .sort() and .binarySearch*() using external libraries like .Arrays.

## Common Optimization / Refactor Tips

### Use a `HashSet` instead of a `List` for fast lookup

Slower:

```java
list.contains(x); // O(n)
```

Faster:

```java
set.contains(x); // usually O(1)
```

Use this for duplicate checks, seen values, and quick existence checks.

---

### Use a `HashMap` for counting

```java
Map<String, Integer> count = new HashMap<>();

for (String word : words) {
    count.put(word, count.getOrDefault(word, 0) + 1);
}
```

Use this when tracking frequencies.

---

### Use sorted strings as keys for anagrams

```java
char[] chars = word.toCharArray();
Arrays.sort(chars);
String key = new String(chars);
```

Words with the same sorted key are anagrams.

---

### Avoid repeating logic

If you write the same code multiple times, make it a helper method.

Example:

```java
private static String getSortedKey(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
}
```

---

### Prefer clear variable names

Instead of:

```java
Map<String, List<String>> m = new HashMap<>();
```

Use:

```java
Map<String, List<String>> anagramGroups = new HashMap<>();
```

Clear names make debugging easier.

---

### Think about the data structure first

Use:

* `Array/List` when order matters
* `Set` when uniqueness matters
* `Map` when key-value relationships matter
* `Stack/Queue` when order of processing matters
* `StringBuilder` when building strings repeatedly

# Two Sum
The brute force solution to the Two Sum problem checks every possible pair of elements in the array starting at index 0. This approach requires a nested loop, resulting in a worst-case time complexity of O(n^2), which is highly inefficient for large datasets.To optimize this, we must recognize that for any given number, the exact value needed to reach the target is its complement, calculated as Target - Current. Instead of scanning the remaining array elements to find this complement, we can use a hash map to look it up instantly in O(1) time, mapping each array value to its corresponding index.This approach is highly efficient because it only requires a single pass through the array. When iterating, we calculate the complement of the current number and check if it already exists in our hash map. If it does, we immediately return the current index and the stored index of the complement; if it does not, we insert the current number and its index into the map and move forward.A single pass is guaranteed to find the solution due to the symmetrical nature of the target pair. If element A appears before element B in the array, B will not be in the map when we process A. However, when the loop eventually reaches B, element A is guaranteed to be waiting in the hash map, allowing us to find the match without pre-populating the data structure.This optimized algorithm achieves a time complexity of O(n) because we traverse the list exactly once and perform constant-time hash map operations. The space complexity is also O(n) since, in the worst-case scenario where the matching pair is at the very end of the array, we will store up to n elements in our hash map.