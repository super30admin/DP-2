//Accepted on LT
//The idea was same to coin 1 but instead maintain coins used we used number of possible ways this time
// Time should size o matrix O(mn)

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0],0);
        dp[0][0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
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