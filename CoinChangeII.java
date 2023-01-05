public class CoinChangeII {

//TIme Complexity - O(m*n)
    //SC - O(m*n)

    public int change(int amount, int[] coins) {
        if(coins == null || coins.length ==0 ) return 0;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i<n+1;i++) dp[i][0]=1;
        for(int i = 1; i<n+1;i++){
            for(int j = 1; j<amount+1;j++){
                if(j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
            }


        }
        return dp[n][amount];

    }





    //exhaustive approach
    //TimeC  exponential
    //Space - recursive stack space
    /*
     public int change(int amount, int[] coins) {
        if(coins == null || coins.length ==0 ) return 0;
        return dfs(amount,coins, 0);
    }
    private int dfs(int amount,int[] coins, int index){
       // if(coins == null || coins.length ==0) return 0;
        if(amount<0 || index== coins.length) return 0;
        if(amount==0) return 1;
        int case0 = dfs(amount, coins,index+1);
        int case1 = dfs(amount-coins[index],coins,index);
        return case0+case1;
    }
    * */
}
