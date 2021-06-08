// 518. Coin Change 2

class Solution {
    public int change(int amount, int[] coins) {
    int [][] dp = new int[coins.length + 1][amount + 1];
        
    // for first column
    for( int i=0; i<dp.length; i++)
    {
        dp[i][0] = 1;
    }
     
    for(int i = 1; i<dp.length; i++)
    {
        for(int j = 1; j< dp[0].length; j++)
        {
            if(j < coins[i-1])
            {
                dp[i][j] = dp[i-1][j];  // zero case just getting elements from above 
            }
            else {
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
    }
        return dp[coins.length][amount];
 
    }
}

/*
Complexity Analysis

Time complexity: 
O(N×amount), where N is a length of coins array.

Space complexity: 
O(amount) to keep dp array.
*/