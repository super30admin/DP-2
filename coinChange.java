class Solution {
    public int change(int amount, int[] coins) {
         int m=coins.length; int n=amount;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int j=0;j<dp[0].length;j++){
            if(j==0)
                dp[0][j]=1;
            else
                dp[0][j]=0;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+ dp[i][j-coins[i-1]];
                }
            }
        }
        
            return dp[dp.length-1][dp[0].length-1];
    }
    
}