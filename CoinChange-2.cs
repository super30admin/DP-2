using System;
namespace Algorithms
{
    public class CoinChange_2
    {
        /// Time Complexity : O(N*amount) 
        // Space Complexity :O(amount) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int CoinChange(int[] coins, int amount)
        {
            int rows = coins.Length + 1;
            int columns = amount + 1;
            int[][] dp = new int[rows][];
            for (int i = 0; i < rows; i++)
            {
                dp[i] = new int[columns];
            }
            for (int j = 0; j < dp.Length; j++)
            {
                dp[j][0] = 1;
            }
            for (int row = 1; row < rows; row++)
            {
                for (int column = 1; column < columns; column++)
                {
                    if (column < coins[row - 1])
                    {
                        dp[row][column] = dp[row - 1][column];
                    }
                    else
                    {
                        dp[row][column] = dp[row - 1][column] + dp[row][column - coins[row - 1]];
                    }
                }
            }
            return  dp[coins.Length][amount];
            
        }
    }
}
