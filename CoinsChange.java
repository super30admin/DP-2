//Time Complexity : O(M X N)
//Space Complexity : O(M X N)
//Did code run successfully on LeetCode : Yes

class Solution {
    public int change(int amount, int[] coins) {
        
        int n = amount;
        int m = coins.length;
        
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];   
    }
}