package com.ds.rani.dp;

/**
 * coin-change-2
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 *
 * 5=2+2+1
 *
 * 5=2+1+1+1
 *
 * 5=1+1+1+1+1
 */
//Approach:create 2D array odf size number of columns+1 by amount+1,
// Then check if my current denominator is less than the amount to be achieved then take
public class CoinChange2 {

    //Time complexity o(m*n)
    //Space complexity o(m*n)    where m: amount and n:number of coins
    public static int change(int amount, int[] coins) {
        //create 2D array odf size number of columns+1 by amount+1
        int[][]dp=new int[coins.length+1][amount+1];

        //Fill first column with 1
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=1;
        }
        //
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //take the value from the above row same colum
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    //take the value from above + demomination number before of current colum
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }
    public static void main(String[] args) {
         int[] coins={1, 2, 5};
        System.out.println(CoinChange2.change( 5,coins));
    }
}
