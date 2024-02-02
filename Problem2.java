// Time Complexity : O(m*n) where n = number of coins; m = amount
// Space Complexity : O(m) where m = amount (optimized with using 1d DP array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * Designed a decision tree by either choosing a coin or not (exhaustive
 * approach). Converted that tree into a 1d DP array. At any given coin and
 * amount, output is on previous coin same amount + current coin's (amount -
 * coinValue). Which are essentially choose or no choose scenarios in the tree.
 * The final index of the DP array returns the solution
 */

class Problem2 {
    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return 0;
        }
        // using 1d dp array; amount + 1 to store the 0th index
        int[] dp = new int[amount + 1];

        // populating the first dp array row
        for (int i = 0; i < dp.length; i++) {
            // can only make the amount with one coin if amount is a multiple
            // and there's only one way: using coin * x = amount
            if (i % coins[0] == 0) {
                dp[i] = 1;
            }
        }

        // we have solution with one coin; now we can derive 2 coins and so on
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                // value is same till amount reaches value of coin
                if (j < coins[i]) {
                    continue;
                }
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[dp.length - 1];
    }
}