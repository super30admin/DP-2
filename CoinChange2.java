// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CoinChange2 {
    int count;
    public int change(int amount, int[] coins) {
       int m = coins.length;
       int n = amount;

        // We add +1 for 0 location
       int dp[][] = new int[m+1][n+1];  
       dp[0][0] = 1;

       for(int i=1; i<=m; i++) {
        for(int j=0; j<=n; j++) {
            if(j < coins[i-1]) {
                dp[i][j] = dp[i-1][j];
            } else {
                 dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
         
       }
       return dp[m][n];
    }
