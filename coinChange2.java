// Time Complexity : O(mn), m = number of coins, n = amount
// Space Complexity : O(n), n = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Implemented a bottom up approach. At each coin, we have 2 choices, either we can take the coin or not.
 * If we pick a coin, we will add the number of ways to get the remaining amount with the same coin.
 * If we don't pick a coin, we will add the number of ways to get the amount with the remaining coins.
 * pick will return 1, if the amount becomes 0, else it will return 0.
 */


class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length, n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j >= coins[i-1]){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        return dp[n];
    }
}