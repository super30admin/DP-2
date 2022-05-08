using System;
namespace Algorithms
{
    /// Time Complexity : O(N) 
    // Space Complexity :O(1) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class DP_Paint_House
    {
        public int MinCost(int[][] costs)
        {
            if (costs == null && costs.Length == 0) return 0;
            int n = costs.Length;
            int costR = costs[n - 1][0];
            int costB = costs[n - 1][1];
            int costG = costs[n - 1][2];

            for (int i = n - 2; i >= 0; i--)
            {

                int tempR = costR;
                int tempB = costB;
                costR = costs[i][0] + Math.Min(costB, costG);
                costB = costs[i][1] + Math.Min(tempR, costG);
                costG = costs[i][2] + Math.Min(tempR, tempB);
            }

            return Math.Min(costR, Math.Min(costB, costG));
        }
    }
}
