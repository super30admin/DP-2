public class PaintHouse
    {
        // Time Complexity : O(n * 3) ~ O(n) where n is number of houses 
        // Space Complexity : O(3n) ~ O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        //Matrix DP
        public int minCostsMatrix(int[][] costs)
        {
            int n = costs.Length;
            int[,] dp = new int[n,3];

            //fill the last row with the same values
            dp[n - 1, 0] = costs[n - 1][0];
            dp[n - 1, 1] = costs[n - 1][1];
            dp[n - 1, 2] = costs[n - 1][2];

            for(int i = n - 2; i >= 0; i--)
            {
                dp[i, 0] = costs[i][0] + Math.Min(dp[i + 1, 1], dp[i + 1, 2]);
                dp[i, 1] = costs[i][1] + Math.Min(dp[i + 1, 0], dp[i + 1, 2]);
                dp[i, 2] = costs[i][2] + Math.Min(dp[i + 1, 0], dp[i + 1, 1]);
            }
            return Math.Min(dp[0, 0], Math.Min(dp[0, 1], dp[0, 2]));
        }

        // Time Complexity : O(n* 3) ~O(n) where n is number of houses
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        //using only single array
        public int minCostsArray(int[][] costs)
        {
            int n = costs.Length;
            int[] dp = new int[3];

            //fill the last row with the same values
            dp[0] = costs[n - 1][0];
            dp[1] = costs[n - 1][1];
            dp[2] = costs[n - 1][2];

            for (int i = n - 2; i >= 0; i--)
            {
                int tempR = dp[0]; 
                dp[0] = costs[i][0] + Math.Min(dp[1], dp[2]);
                int tempB = dp[1];
                dp[1] = costs[i][1] + Math.Min(tempR, dp[2]);
                dp[2] = costs[i][2] + Math.Min(tempR, tempB);
            }
            return Math.Min(dp[0], Math.Min(dp[1], dp[2]));
        }

        // Time Complexity : O(n* 3) ~O(n) where n is number of houses
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        //using just 3 variables
        public int minCostsVariables(int[][] costs)
        {
            int n = costs.Length;

            //fill the last row with the same values
            int costR = costs[n - 1][0];
            int costB = costs[n - 1][1];
            int costG = costs[n - 1][2];

            for (int i = n - 2; i >= 0; i--)
            {
                int tempR = costR;
                costR = costs[i][0] + Math.Min(costB, costG);
                int tempB = costB;
                costB = costs[i][1] + Math.Min(tempR, costG);
                costG = costs[i][2] + Math.Min(tempR, tempB);
            }
            return Math.Min(costR, Math.Min(costB, costG));
        }
    }
