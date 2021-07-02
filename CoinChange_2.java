// Time Complexity : O(m*n) , m=total coins, n=total amount
// Space Complexity : O(m*n), m=total coins, n=total amount
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1]; //initialising the matrix
        
        if(coins==null || coins.length==0) //edge consitions
            return 0;
        
        for(int i=0; i<=coins.length; i++) //for amount=0, there is 1 way for each denomination
            dp[i][0] = 1;
        
        for(int i=1; i<=coins.length; i++)
            for(int j=1; j<=amount; j++)
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; //total number of ways to make the amount
       
        return dp[coins.length][amount]; //returning the last value which is the total sub arrays
    }
}