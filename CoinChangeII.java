// Time Complexity : O(coins.length x amount)
// Space Complexity :  O(coins.length x amount)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/coin-change-ii/submissions/1052242990/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Using exhaustive approach, you can find the number of ways which makes the amount as 0 and return it, but it exceeds the time due to repeated sub problems
 * to solve above problem, we're using DP array and storing the repeated values
 * The last row and index results in all the possible combinations of the given amount with the given dominations
 
 * Notes: fill the first column with 0, since for amount 0, not picking any denomination is the only way
 * and first row with 0
 */

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j< amount+1; j++){
                if(j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j]+ dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}