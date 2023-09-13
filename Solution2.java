// Leetcode Problem : https://leetcode.com/problems/coin-change-ii/description/
// Time Complexity : O(n*m) where n is the number of coins and m is the amount
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 I create a dp[][] array with dimensions coins.length+1 * amount+1. I fill up the first
 column with 1 since there is 1 way to make an amount = 0 with any denomination. Now for
 every subsequent element that don't belong to the first row and first column, if coins[i-1] >j,
 I set the value of dp[i][j]=dp[i-1][j]. Else I set dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
 and return dp[rows-1][columns-1]
 */



class Solution {
    public int change(int amount, int[] coins) {
        int rows = coins.length+1;
        int columns = amount+1;
        int dp[][] = new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            dp[i][0]=1;
        }
        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<columns;j++)
            {
                if(coins[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[rows-1][columns-1];

    }
}