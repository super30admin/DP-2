// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public int Change(int amount, int[] coins) {
        
        if(coins == null || coins.Length == 0)
            return 0;
        
        int[,] dp = new int[coins.Length+1, amount+1];
        
        //for amount = 0, there is only 1 way of chossing, not choose any coing
        for(int i = 0; i < dp.GetLength(0); i++)
        {
            dp[i,0] = 1;
        }
        
        //for remainigng aount and 0 coins, there is no option, so set number of ways to 0
        for(int j = 1; j < dp.GetLength(1); j++)
        {
            dp[0,j] = 0;
        }
        
        for(int i = 1; i < dp.GetLength(0); i++)
        {
            for(int j = 1; j < dp.GetLength(1); j++)
            {
                //this means, amount is less than coin we are using, it will result to negative amount
                //so we just copy maximum number of ways of not choosing the current coin
                //that scenario will lie above row and same column
                if(j < coins[i-1])
                    dp[i,j] = dp[i-1,j];
                else
                    //otherwise take one abive and 
                    //value at current row, amount(column) - coin value(current row)

                    dp[i,j] = dp[i-1,j] + dp[i,j-coins[i-1]];
            }
        }
                
        return dp[coins.Length,amount];
    }