// Time Complexity : O(n*m) where n is the number of coins and m is the amount
// Space Complexity : O(m) where m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length,m=amount;
        int dp[]=new int[m+1]; //space optimization
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                // If the coin value is greater than the current amount, we can't use it
                if(coins[i-1]>j)   
                    dp[j]=dp[j];
                else
                // Add the number of ways excluding this coin (dp[j]) and including this coin (dp[j - coin value])
                    dp[j]=dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[m];
    }
}