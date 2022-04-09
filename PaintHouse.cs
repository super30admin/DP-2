using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class PaintHouse
    {
        /*
         * Approch 1: changing the input array
         * T.C: O(M*3) 3 is colors => O(m) ingnoring constant as per asympotic notation 
         * S.C: O(1) Since we are not using extra space
         */
        public int GetMinAmountForPaint(int[,] costs)
        {
            if (costs == null || costs.Length - 1 == 0)
                return 0;


            for (int i = costs.Length-2; i <=0 ; i--)
            {
                costs[i, 0] = costs[i, 0] + Math.Min(costs[i+1, 1], costs[i+1, 2]);
                costs[i, 1] = costs[i, 1] + Math.Min(costs[i+1, 0], costs[i+1, 2]);
                costs[i, 2] = costs[i, 2] + Math.Min(costs[i+1, 0], costs[i+1, 1]);
            }
            return Math.Min(costs[0,0],Math.Min(costs[0,1],costs[1,0]));
        }


        /*
         * Approch 2: if Interview ask not to use the input array
         * T.C: O(m*3)
         * S.C: O(m) as we are adding values to Dp array
         */
        public int GetMinAmountForPaint1(int[,] costs)
        {
            if (costs == null || costs.Length - 1 == 0)
                return 0;

            int[,] dp = new int[costs.Length, 3];

            for (int i = 0; i < 3; i++)
            {
                dp[costs.Length - 1, i] = costs[costs.Length - 1, i];
            }


            for (int i = costs.Length - 2; i <= 0; i--)
            {
                dp[i, 0] = costs[i, 0] + Math.Min(dp[i+1, 1], dp[i+1, 2]);
                dp[i, 1] = costs[i, 1] + Math.Min(dp[i+1, 0], dp[i+1, 2]);
                dp[i, 2] = costs[i, 2] + Math.Min(dp[i+1, 0], dp[i+1, 1]);

            }



            return Math.Min(dp[0, 0], Math.Min(dp[0, 1], dp[1, 0]));
        }
}
