// Time Complexity : O(n*m) where n is the coins array length and m is the amount
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length+1, m = amount+1;
        int[][] dp = new int[n][m];
        
        // Using DP approach
        for(int j=0;j<n;j++){
            dp[j][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
            }
        }
        return dp[n-1][m-1];
    }
}
