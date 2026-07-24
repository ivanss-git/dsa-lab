package sliding_window;
public class MinimumWindowSubstring {
    public String solution(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Count required characters for target string 't'
        int[] targetCounts = new int[128];
        int requiredUniqueChars = 0;
        for (int i = 0; i < t.length(); i++) {
            if (targetCounts[t.charAt(i)] == 0) {
                requiredUniqueChars++;
            }
            targetCounts[t.charAt(i)]++;
        }

        // Step 2: Initialize tracking variables for the sliding window
        int[] windowCounts = new int[128];
        int formedUniqueChars = 0;
        
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int bestStartIndex = 0;

        // Step 3: Expand the window using the 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);
            windowCounts[charRight]++;

            // If the current character meets the required frequency in 't'
            if (targetCounts[charRight] > 0 && windowCounts[charRight] == targetCounts[charRight]) {
                formedUniqueChars++;
            }

            // Step 4: Shrink the window from the left if it's currently valid
            while (formedUniqueChars == requiredUniqueChars) {
                // Update our best window if this one is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    bestStartIndex = left;
                }

                // Try to shrink the window by moving 'left'
                char charLeft = s.charAt(left);
                windowCounts[charLeft]--;

                // If shrinking breaks the validity condition
                if (targetCounts[charLeft] > 0 && windowCounts[charLeft] < targetCounts[charLeft]) {
                    formedUniqueChars--;
                }

                left++; 
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(bestStartIndex, bestStartIndex + minLength);

    }
    public static void main (String[] args) {
        String str = "zxcvbnmasdfghjklqwertyuiop";
        String subStr = "zgp";
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.printf("\nOutput: %s", mws.solution(str, subStr));
    }
} 