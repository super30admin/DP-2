/*
Time Complexity = O(amount * coins)
Space Complexity = O(amount * coins)
Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class CoinChange2 {
}

class SolutionA1 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int i = 0; i < n+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][amount];

        // return helper(0, amount, coins);

    }

    private int helper(int index, int amount, int[] coins){ //time complexity is exponential
        //base cases
        if(amount < 0 || index == coins.length){ //if index was increased by 2 -> index >= 0 needed
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        //logic
        //do not choose case i.e. case 0
        int case1 = helper(index+1, amount, coins);
        //choose case i.e. case 1
        int case2 = helper(index, amount - coins[index], coins);

        return case1 + case2;

    }
}
