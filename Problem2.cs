public class CoinChange2
    {
        // Time Complexity : O(m * n) where m is the number of coins and n is the amount 
        // Space Complexity : O(n) - as we optimized to use an Array from Matrix for DP tabulation
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int Change(int amount, int[] coins)
        {
            if (coins == null || coins.Length == 0) return 0;

            int m = coins.Length;
            int n = amount;

            int[] dp = new int[n + 1];

            dp[0] = 1;//coin 0 amount 0 


            for (int i = 1; i < m + 1; i++)
            {
                for (int j = 1; j < n + 1; j++)
                {
                    //until the amount reaches the coins denomination
                    if (j < coins[i - 1])
                    {
                        //case=0 from above
                        dp[j] = dp[j];
                    }
                    else
                    {
                        //      case 0           case 1
                        dp[j] = dp[j] + dp[j - coins[i - 1]];
                    }
                }
            }
            return dp[n];
        }
    }
