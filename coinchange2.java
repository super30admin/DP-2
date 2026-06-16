// Time Complexity : O(m * n) where m is the number of coins and n is the amount.
// Space Complexity : O(n) for the DP array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : correct order of iteration for the DP solution.
// Your code here along with comments explaining your approach: dp array of size n+1 where n is the amount. The value at dp[j] will represent the number of combinations to make up the amount j using the coins available. The base case is dp[0] = 1, which means there is one way to make up the amount 0 (using no coins). We iterate through the coins and for each coin, we iterate through the amounts from 0 to n. If the current amount j is greater than or equal to the coin value, we add the number of combinations to make up the amount j - coin value to dp[j]. Finally, we return dp[n] which will give us the number of combinations to make up the amount n.

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j >= coins[i-1]){
                    dp[j] = dp[j] +  dp[j - coins[i-1]];
                }
            }
        }

        return dp[n];
    }
}
