package backtracking;

import java.util.ArrayList;
import java.util.List;

public class TemplateJava {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return list;
    }

    public void backtrack(int start, List<Integer> current) {
        // Base case: every valid state is a subset, so add it immediately
        list.add(new ArrayList<>(current)); 

        // Loop through choices (the remaining numbers)
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);         // Make choice
            backtrack(i + 1, current);    // Move to next step
            current.remove(current.size() - 1); // Undo choice
        }
    }
}
