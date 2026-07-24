package arrays_and_hashing;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class TopKFrequent {
    @SuppressWarnings("unchecked")
    public int[] solution (int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            // if num not in map, gets 0 + 1. Otherwise, gets current count + 1.
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // compiler cannot guarantee at compile time that thw raw list
        // actually contains the correct object type because java uses type erasure
        // warnig - occurs when you assign a raw, untyped list to a parameteresized generic List<type>
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : hm.keySet()) {
            int frequency = hm.get(num);
            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                result[index] = num;
                index++;

                if (index == k) {
                    return result;
                }
            }
        }


        return result;

    }
    public static void main (String[] args) {
        TopKFrequent tf = new TopKFrequent();
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        int[] output = tf.solution(nums, k);
        System.out.print(Arrays.toString(output));


    }
    
}

/**
 *  A better version would be : 
 * 
 * HashMap<Integer, Integer> map = new HashMap<>();
 * 
 * // count frequency
 * for (int num : nums) {
 *      map.put(num, map.getOrDefault(num, 0) + 1 );
 * }
 * 
 * // convert keys to list 
 * List< Integer> list = new ArrayList<>(map.KeySet());
 * 
 * // sort frequency in descending order
 * list.sort((a,b) -> map.get(b) - map.get(a));
 * 
 * // take top k element
 * int[] result = new int[k];
 * 
 * for (int i = 0; i < k; i++) {
 *      result[i] = list.get(i)
 * }
 * 
 * return result;
 * }
 * }
 * 
 * 
 */