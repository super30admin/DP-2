// Time Complexity : O(N*M) N = length of coins array and M = amount
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// The basic idea is we can either choose a coin or not choose a coin to achieve the amount 
// We use DP to simulate both the cases and update the DP array accordingly
// We finally return the number of ways we can get the amount using the given array of coins
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;
        
        int[][] dp = new int[coins.length + 1][amount+1];
        for(int i=0; i< dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1; i< dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j]  = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}