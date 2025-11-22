// Time Complexity :O(mn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//I used a DP array where dp[i] stores the number of ways to make amount i.
// For each coin, I iterate through all amounts ≥ coin value and update dp[j] += dp[j - coin] to add combinations including this coin.
// At the end, dp[amount] contains the total number of combinations to form the target amount.

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        if (amount <0 || n == 0){
            return 0;
        }
        for (int i = 0; i < n; i++){
            for (int j = coins[i]; j < amount+1; j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}