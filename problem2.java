// Time Complexity : o(n * m)
// Space Complexity :o(n * m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//coin change 2

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;
        int m = amount + 1;

        int[][] dp = new int[n][m];

        for(int j = 1; j < m; j ++){
            dp[0][j] = 0;
        }

        for(int i = 0;i < n;i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n;i++){
            for(int j = 1; j < m; j ++){
                if( coins[i - 1] > j){
                    dp[i][j] = dp[i -1][j];
                }

                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}