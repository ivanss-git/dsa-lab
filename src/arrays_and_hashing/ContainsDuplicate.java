package arrays_and_hashing;
import java.util.HashSet;
import utils.MyClass;
public class ContainsDuplicate {
    public boolean calculate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                MyClass.log("Contains a duplicate;");
                return true;
            } else {
                set.add(num);
            }
        }
        MyClass.log("Does not contain a duplicate.");
        return false;
    } 
    public static void main (String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] array = {1, 2, 3, 3};
        cd.calculate(array);
    }
    
}
