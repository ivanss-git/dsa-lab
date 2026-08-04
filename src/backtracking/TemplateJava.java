package backtracking;

import java.util.ArrayList;
import java.util.List;

public class TemplateJava {
    int[] nums;

    public void backtrack(int index, int remainingTarget, List<Integer> current, int[] nums, List<List<Integer>> result) {

        if (remainingTarget == 0) { 
            result.add(new ArrayList<>(current)); 
            return;
        }
        if (remainingTarget < 0 || index == nums.length) {
            return;
        }
           
        // Loop through choices (the remaining numbers)
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);   // Make choice
            backtrack(i, remainingTarget - nums[i], current, nums, result);    // Move to next step
            current.remove(current.size() - 1); 
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, target, current, nums, result);
        return result;
    }
}
