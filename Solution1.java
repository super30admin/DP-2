// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I create a dp[][] array of dimensions (coins.length + 1) * (amount + 1). I initially set dp[0][0] as 1 and set all other values of the first row to 0.
 * Now I iterate through each element from the second row and set the value of dp[i][j] as that of the value just above it for all j<coins[i-1]. For other instances, 
 * dp[i][j] = sum of the value just above and 1+value present coins[i-1] places behind in the same row.
 */

class Solution1 {
    public int change(int amount, int[] coins) {
        int rows=coins.length+1;
        int columns = amount+1;
        int [][]dp = new int[rows][columns];

        dp[0][0]=1;
        for(int i=1;i<columns;i++)
        {
            dp[0][i]=0;
        }
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(j<coins[i-1])
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