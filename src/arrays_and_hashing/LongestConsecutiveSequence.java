package arrays_and_hashing;
import java.util.Arrays;

public class LongestConsecutiveSequence {
    public class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);
            int currentStreak = 1;
            int longestStreak = 1;

            for (int i = 0; i < nums.length - 1; i++) {
                int difference = nums[i + 1] - nums[i];

                if (difference == 1) {
                    currentStreak++;
                } else if (difference > 1) {
                    currentStreak = 1;
                }
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
            return longestStreak;
        }
    }
    public static void main (String[] args) {
        int[] example = {2,20,4,10,3,4,5};
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.new Solution().longestConsecutive(example));
    }
}
