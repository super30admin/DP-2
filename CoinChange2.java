// Time Complexity o(n*m) space complexity is o(n*m);
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        int n=coins.length,m=amount;
        int[][] dp =new int[n+1][m+1];
        dp[0][0]=1;
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][m];
    }
    
}