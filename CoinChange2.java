package com.dp2;

public class CoinChange2 {

    public int change(int amount, int[] coins) {

        if(coins == null){
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];
        int m = dp.length;
        int n = dp[0].length;
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        CoinChange2 sol = new CoinChange2 ();
        System.out.println (sol.change (5,new int[]{1, 2, 5}));
    }

}
