package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || k < 0) {
            return -1;
        }

        int left = 0;
        int mostFrequent = 0;
        int maxLength = 0;
        int[] array = new int[126];

        for (int right = 0; right < s.length(); right++) {
            array[s.charAt(right) - 'A']++;
            mostFrequent = Math.max(mostFrequent, array[s.charAt(right) - 'A']);

            while ((right - left + 1) - mostFrequent > k) {
                array[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(mostFrequent, right - left + 1);
        }
        return maxLength;
    }
    public static void main (String[] args) {
        LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
        String s = "XYYX";
        int k = 2;
        System.out.printf("Output: ", lrcr.characterReplacement(s, k));
    } 
}
