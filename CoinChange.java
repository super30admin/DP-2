/* Time Complexity : O(M * N), where M = length of coins array and N = amount
   Space Complexity : O(M * N), where M = length of coins array and N = amount
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Method:DP

*/

class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(j<coins[i-1]) // amount or capacity less than the coin value. keep the previous value at the same capacity
                    dp[i][j] = dp[i-1][j];
                else
                {
                    if(j-coins[i-1]==0) // if the capacity and current coin difference is 0, then add the dont consider by 1
                        dp[i][j] = dp[i-1][j] + 1;
                    else 
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}