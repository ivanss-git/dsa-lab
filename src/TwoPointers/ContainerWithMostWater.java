package TwoPointers;

public class ContainerWithMostWater {
    public class Solution {
        public int maxArea(int[] heights) {
            int result = 0;
            int n = heights.length;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int width = j - i;
                    int containerHeight = Math.min(heights[i], heights[j]);
                    int area = containerHeight * width;
                    result = Math.max(result, area);
                }
            }
            return result;
        }
    }
    public static void main (String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] example = {1,7,2,5,4,7,3,6};
        System.out.printf("Output:", cwmw.new Solution().maxArea(example));

    }
    
}
