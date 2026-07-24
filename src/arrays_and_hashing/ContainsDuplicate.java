package arrays_and_hashing;
import java.util.HashSet;
//import java.util.HashMap;

public class ContainsDuplicate {
    public boolean calculate(int[] nums) {
        // So this works but it's not as efficient.
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(nums[i])) {
        //         System.out.print("Contains duplicate.");
        //         return true;
        //     } else {
        //         map.put(nums[i], i);
        //     }
        // }
        // System.out.println("Does not contain Duplicate.");
        // return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                System.out.print("Contains a duplicate;");
                return true;
            } else {
                set.add(num);
            }
        }
        System.out.print("Does not contain a duplicate.");
        return false;
    } 
    public static void main (String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] array = {1, 2, 3, 3};
        cd.calculate(array);
    }
    
}
