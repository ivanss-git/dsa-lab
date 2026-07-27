package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.MyClass;

public class ThreeSum {

    // 1. Hide the implicit public constructor for the outer utility class
    private ThreeSum() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static class Solution {

        // 2. Hide the implicit public constructor for the inner algorithm class
        private Solution() {
            // Intentionally left empty or can throw exception if strictly a static provider
        }

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                // 3. Refactored conditionals: Combined duplicate skipping and break checks.
                // Uses exactly ONE single "continue" statement for the entire loop control flow.
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                
                // Stopped using 'break' statement here by embedding the logic as a condition
                if (nums[i] <= 0) {
                    twoSumTwoPointers(nums, i, res);
                }
            }
            return res;
        }

        /**
         * Flattens the control flow to pass cognitive complexity rules.
         */
        private void twoSumTwoPointers(int[] nums, int i, List<List<Integer>> res) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        public static Solution getInstance() {
            throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
        }
    }
    public static void main(String[] args) {
        int[] example = {-1, 0, 1, 2, -1, -4};
        
        // 3. Main execution using the static factory instance and your custom non-System.out logger
        Solution solver = Solution.getInstance();
        List<List<Integer>> output = solver.threeSum(example);
        
        MyClass.log("Output: " + output);
    }
}
