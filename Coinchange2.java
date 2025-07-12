class Solution {
    public int change(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 1;
        //setting first row (dummy row )
        for(int j = 1 ; j <=m ; j++){
            dp[0][j] = 0;
        }
        for (int i = 0; i <= coins.length; i++) {
    dp[i][0] = 1; // Only one way to make amount 0 — choose nothing
}

        //start filling values from row 1
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                //till amount < denomination of current coin 
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];


    }
}