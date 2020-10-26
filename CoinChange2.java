package S30.DP_2;

/*DP Solution
Time Complexity : Put: O(mn),  m is coins.length, n is amount
Space Complexity : O(mn),  m is coins.length, n is amount
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class CoinChange2 {

    //Recursive solution
    public int recursiveChange(int amount, int[] coins) {

        if(coins == null) return 0;
        return helper(amount,coins,0);
    }

    private int helper(int amount, int[] coins, int index){

        if(amount == 0) return 1; //don't have to use up all the coins

        if(amount < 0 || index >= coins.length) return 0;


        //not choose the coin
        int case1 = helper(amount, coins, index+1);

        //choose the coin
        int case2 = helper(amount - coins[index], coins, index);

        return case1 + case2;
    }

    //DP Solution
    public int change(int amount, int[] coins) {

        if(coins == null) return 0;


        int[][] dp = new int[coins.length+1][amount+1];
        int m = dp.length;
        int n = dp[0].length;

        //number of coins available = 0, no of ways to make amount = 0
        for(int j = 1; j < n; j++){
            dp[0][j] = 0;
        }

        //amount to make = 0, number of possible ways = 1 { empty array}
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){

                dp[i][j] = dp[i-1][j]; // if you don't choose this coin
                if(j - coins[i-1] >= 0){ // if possible, choose this coin
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m-1][n-1];

    }
}
