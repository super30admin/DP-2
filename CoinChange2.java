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
        
    }   
    
}