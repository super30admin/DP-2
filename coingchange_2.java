// Time Complexity : O(log(m*n))
// Space Complexity : O(log(m*n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        int m=coins.length;
        int n=amount;
        
        int[][] dp = new int [m+1][n+1];
        
        for(int i=1;i<m+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
