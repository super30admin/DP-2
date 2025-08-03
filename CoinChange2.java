
// Idea is to use dynamic programming to solve smaller sub problems.
// Each sub problem is to use a subset of coins to achieve particular sum - two parameters.
//So, a 2d matrix is used in bottom up approach.

//Time Complexity: O(mxn)
//Space Complexity: O(mxn)
 
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for(int i=1;i<=m;i++)
        {
            for(int j=0;j<=n;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
 