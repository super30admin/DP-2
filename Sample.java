
// Time Complexity: O(n), where n is the number of houses
//   - We process each house once and do constant work per house
// Space Complexity: O(1)
//   - Only a fixed array of size 3 is used regardless of input size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int minCost(int[][] costs) {        
        int[] dp = new int[3]; // dp[i] holds min cost if the last house is painted with color i
        
        for(int i=0; i<costs.length; i++){
            // Calculate current costs based on previous row
            int dp0 = costs[i][0] + Math.min(dp[1], dp[2]); // Paint red
            int dp1 = costs[i][1] + Math.min(dp[0], dp[2]); // Paint blue 
            int dp2 = costs[i][2] + Math.min(dp[0], dp[1]); // Paint green
            
            // Update dp with new costs
            dp[0] = dp0; dp[1] = dp1; dp[2] = dp2;
        }
        // Return minimum of final choices
        return Math.min(dp[0], Math.min(dp[1], dp[2]));   
    }
}

// Time Complexity: O(amount * n), where n is the number of coins
//   - For each coin, we update the DP array for all amounts from coin to target
// Space Complexity: O(amount), for the 1D DP array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        // Base case: one way to make amount 0 — by choosing no coins
        dp[0] = 1;

        // For each coin, update the number of ways to make all amounts >= coin
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount]; // Final answer: number of ways to make 'amount'
    }
}
