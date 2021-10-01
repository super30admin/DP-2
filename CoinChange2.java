// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;
        int m = amount + 1;

        // Initialise our dp matrix;
        int[][] dp = new int[n][m];

        //Initilize the column
        for(int j = 1; j<m ; j++){
            dp[0][j] = 0;
        }
        for(int i = 0;i< n ;i++){
            dp[i][0] = 1;

        }

        for(int i = 1; i< n;i++){
            for(int j = 1; j<m;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];

                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[n-1][m-1];






    }
}