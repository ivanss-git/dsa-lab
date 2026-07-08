package ArraysAndHashing;
import java.util.Arrays;

/**
 * Works by calculating a left and sum product then multiplying it by one another to get the end result.
 * 
 */
public class ProdOfArrExceptSelf {
   public int[] solution(int[] nums) {
        int[] output = new int[nums.length];

        int rightSum = 1;
        for (int i = (nums.length - 1); i >= 0; i--) {
            output[i] = rightSum;
            rightSum *= nums[i];
        }

        int leftSum = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= leftSum;
            leftSum *= nums[i];
        }
        return output;
   } 

   public static void main (String[] args) {
        int[] nums = {1, 2, 4, 6};
        ProdOfArrExceptSelf poaes = new ProdOfArrExceptSelf();
        int[] result = poaes.solution(nums);
        // we convert the array to string since direct conversion is not allowed
        System.out.printf("Product of array except self for input %s is : %s", Arrays.toString(nums), Arrays.toString(result));
   }
}
