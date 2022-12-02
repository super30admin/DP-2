// Time Complexity : O(mn)
// Space Complexity : O(mn)
//https://leetcode.com/problems/coin-change-ii
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int [m+1][n+1];
        dp[0][0] =1;
        for(int j=1;j<=m;j++){
            dp[j][0] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                    
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
