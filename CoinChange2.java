// Time Complexity : O(mn) traverse given array
// Space Complexity : O(mn) //modify given array
class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        if(coins==null || coins.length==0){
            return 0;
        }
        
        int m = coins.length;
        int n = amount;
        
        int[][]dp = new int[m+1][n+1];
        // fill the 1st column with 1 because amount 0 can be chosen in 1 way
        for(int i =0;i<m+1;i++){
            dp[i][0]=1;
        }
        
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];   // index is not chosen (0 case)
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]; //index is chosen (1 case)
                }
            }
        }
        return dp[m][n];
    }
}