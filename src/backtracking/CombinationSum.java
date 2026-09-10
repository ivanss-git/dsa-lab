package backtracking;

import java.util.List;

import utils.MyClass;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Optional: Sorting helps optimize by stopping early when numbers get too big
        Arrays.sort(nums); 
        
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        // Base case 1: Found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Base case 2: Exceeded the target sum
        if (remain < 0) {
            return;
        }

        // Explore all candidate numbers starting from the current index
        for (int i = start; i < nums.length; i++) {
            // Optimization: If the current number is greater than the remaining target,
            // and the array is sorted, all following numbers will also be too big.
            if (nums[i] > remain) {
                break; 
            }

            // 1. Make a choice: add the number
            tempList.add(nums[i]);
            
            // 2. Explore: recurse with the updated target. 
            // Note: We pass 'i' instead of 'i + 1' because we can reuse the same number.
            backtrack(result, tempList, nums, remain - nums[i], i);
            
            // 3. Undo choice: remove the last number to try other options (backtrack)
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();

        // Test Case 1
        int[] nums1 = {2, 3, 6, 7};
        int target1 = 7;
        MyClass.log("Combinations for target " + target1 + ": " + solver.combinationSum(nums1, target1));
        // Output: [[2, 2, 3], [7]]

        // Test Case 2
        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        MyClass.log("Combinations for target " + target2 + ": " + solver.combinationSum(nums2, target2));
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}
