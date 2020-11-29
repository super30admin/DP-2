package com.dp1;

public class CoinChange {


    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];

        int m = dp.length;
        int n = dp[0].length;

        for(int i=1;i<n;i++){
            dp[0][i]= amount+1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m-1][n-1] == amount+1){
            return -1;
        }

        return dp[m-1][n-1];



    }


    public static void main(String[] args) {
        CoinChange sol = new CoinChange ();

        System.out.println (sol.coinChange (new int[]{1,2,5},11));
    }
}
