package sliding_window;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOf(String s) {
        if (s == null) {
            return -1;
        }
        int left = 0;
        int longest = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
    public static void main (String[] args) {
        String example = "zxyzxyz";
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.printf("Output: ", lswrc.lengthOf(example));

    }
    
}
