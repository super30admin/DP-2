/*
 *  Time Complexity: O(N*M) where N is the number of coins and M is the amount.
 *  Space Complexity: O(N*M) where N is the number of coins and M is the amount. Since we create a dp array of N*M size.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : Design the approach to hold the min element.
 *
 *  Explanation: Create a dp array of size N*M where N is the number of coins and M is the amount. Each cell in this dp array holds the max possible combinations for that particular amount(column value) 
and available coins(current row and above). Each cell can be calculated by summing the value of the combiantion possible without considering the current coin(row value) and considering the current coin(which is the possible combinations when the current target is substracted by the current coin). In the last we return the last value in the dp array.*/
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return amount==0?1:0;
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0)
                   dp[i][j]=1;
                else if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else 
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
