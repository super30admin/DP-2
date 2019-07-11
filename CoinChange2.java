// Time Complexity :O(n*M) where m is no of coins and N is the amount
// Space Complexity :O(S) the space of the memoization table
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Taking into mind to take coins[i-1] in the dp!!



 //Dynamic Programming

class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length+1][amount+1];
        
        dp[0][0] = 1;
        
        for(int i =1; i<coins.length+1; i++)
            dp[i][0] = 1;
        
        for(int i =1; i<coins.length+1;i++)
            for(int j =1; j<amount+1 ; j++)
            {
                if(j<coins[i-1])
                    dp[i][j] =  dp[i-1][j] + 0; //just for understanding
              else  dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        
        return dp[coins.length][amount];
    }
}
