
public class SearchInSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int splitPoint = nums[right] < nums[left] ? right : left;
        if (target <= nums[nums.length - 1]) {
            left = splitPoint;
            right = nums.length - 1;
        } else {
            left = 0;
            right = splitPoint - 1;
        }
        if (right > nums.length - 1 || right < 0) {
            return -1;
        }
        
        while ( right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid]< target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;
    }
   public static void main (String[] args) {
        int[] example = {3,4,5,6,1,2};
        int target = 1;
        SearchInSortedArray sisa = new SearchInSortedArray();
        System.out.printf("Output: ", sisa.search(example, target));

   } 
}
