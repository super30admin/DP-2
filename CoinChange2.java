// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Approach: tabulation DP: create 2D matrix. First row(dummy representing 0 coins) will have 0 in first column and 0 in rest columns. 
//  for every other row dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<coins.length+1;i++){
            for(int j=0;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}