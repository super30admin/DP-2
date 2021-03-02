// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :	No


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        // if(coins == null || coins.length == 0){
        //     return 1;
        // }
        
        int n = coins.length + 1; //coins row length
        int m = amount + 1; //amount column length
        
        int[][] dp = new int[n][m];
        
        for(int i = 0;i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}