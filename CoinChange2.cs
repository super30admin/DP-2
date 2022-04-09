using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class CoinChange2
    {
        /*
         * T.C: O(m*n) where m is length of Coin and n is amount
         * S.C: O(m*n) 
         */
        public int Change(int amount, int[] coins)
        {
            //edge condition
            if (coins == null || coins.Length == 0)
                return 0;

            //Create DP to memorize the alredy find answers
            int[,] dp = new int[coins.Length + 1, amount + 1];

            //base condition for first row for 0 coins that there is 1 way to find amount when we not chose the coin otherwise 
            //need to handle that separately
            for (int i = 0; i < coins.Length+1; i++)
            {
                dp[i, 0] = 1;
            }

            //travers through the dp and check already calculated answers or calculate and store it in DP array
            for (int i = 1; i < coins.Length+1; i++)
            {
                for (int j = 1; j < amount+1; j++)
                {
                    //if coins is less than the amount then copy the amound from previous row
                    if(j<coins[i-1])
                    {
                        dp[i, j] = dp[i - 1, j];
                    }
                    // else sum up the previous row amount and current row diff between amount and coin 
                    else
                    {
                        dp[i, j] = dp[i - 1, j] + dp[i, j - coins[i - 1]];
                    }
                }

            }

            //return last row and column value
            return dp[coins.Length, amount];
        }
    }
}
