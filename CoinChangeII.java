// Time Complexity : O(m * n) m-no. of coins, n-amount
// Space Complexity : O(n) 1D DP array
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a 1D DP array which represents the number of ways to make amount.
// For every coin, iterate through all amounts and add results from previous subproblems.
// dp[j] stores the count of results by choosing the current coin.


class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;

        int[] dp=new int[n+1];
        dp[0]=1;

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[j]=dp[j];
                }
                else{
                    dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];

    }
}