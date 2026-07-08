package ArraysAndHashing;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
  int current_number; // key
  int complement; // value

  // initialize empty HashMap
  HashMap<Integer, Integer> hashmap = new HashMap<>(); 

  public int[] solveTwoSum(int[] nums, int target) {
    // loop through the nums once while tracking the current i
    for (int i = 0; i < nums.length; i++) {
      current_number = nums[i];
      int complement = target - current_number;
      

      // we should use containskey since we want to look at the actual number itself
      if (hashmap.containsKey(complement)) {
        return new int[] { hashmap.get(complement), i};

      } else {
        hashmap.put(current_number, i);
      }
    }
    return new int[] {};
  }

    

   public static void main (String[] args) {
    TwoSum twosum = new TwoSum();
    int[] nums = {2,4,6,8,10};
    int target = 16;
    int[] result = twosum.solveTwoSum(nums, target);
    System.out.println("Indices: " + Arrays.toString(result));
   } 
}

/**
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a standard map to dynamically handle any large number without collisions
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists, we are guaranteed an instant, accurate match
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the value and its index
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
 */
