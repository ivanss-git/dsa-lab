package BinarySearch;

public class FindMinSortedArray {
    public class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                }

                int middle = left + (right - left) / 2;

                if (nums[middle] > nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            return nums[left];
        }
    }
    public static void main (String[] args) {
        int[] example = {3,4,5,6,1,2};
        FindMinSortedArray msa = new FindMinSortedArray();
        System.out.print("Output: "+ msa.new Solution().findMin(example));

    }
    
}
