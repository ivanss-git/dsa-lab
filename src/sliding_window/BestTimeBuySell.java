package sliding_window;
// You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
// You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
// Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
// Example 1:
// Input: prices = [10,1,5,6,7,1]
// Output: 6
// Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

// in summary, we add a new element to the right and subtract the oldest on the left to maintain a windown of elements
// for ours, we'll use a fixed size windown instead of a dynamic windown since we need O(1) space

public class BestTimeBuySell {
    public int maxProfit (int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int left = 0;
        int maxProfit = 0;  

        for (int right = 1; right < prices.length; right++) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            else {
                int currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        // you buy the coin at the current price
        // then sell it for the current price on ith day
        // to be O(1) space, memory does not grow with the size of the input data. (Override and reused what's already allocated)
        return maxProfit;
    } 
    

    public static void main (String[] args) {
    int[] prices = {10, 1, 5, 6, 7, 1};
    BestTimeBuySell bt = new BestTimeBuySell();
    System.out.printf("Maximum Profit: %s", bt.maxProfit(prices));

   } 
}
