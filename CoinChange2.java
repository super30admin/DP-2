// Time Complexity : O(M*N) M is the number of coins and N is the target amount
// Space Complexity : O(M*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to go through the pattern formation as discussed in the class

/* Approach -
 * build the initial row of matrix and according to tree form a pattern while filling the matrix
 * 
 */

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for(int i=1;i<coins.length+1;i++){
            for(int j=0;j<amount+1;j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];

        // For Exhaustive/Recursive Approach
        // return helper(coins,coins.length-1,amount);
        
    }   
    
    /*  Exhaustive/Recursive Approach
     * private int helper(int[] coins,int idx,int amount){
        // base case
        if(amount<0) return 0;
        if(idx<0 && amount>0) return 0;
        if(idx<0 && amount==0) return 1;

        // logic
        // choose
        int case1 = helper(coins,idx,amount-coins[idx]);

        // not choose
        int case2 = helper(coins,idx-1,amount);
        
        return case1+case2; 
    }
     */
}