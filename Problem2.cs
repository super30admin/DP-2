// Time Complexity : O(m*n) where m is the total number of coins and n is the total amount
// Space Complexity : O(n) where n is the total amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution
{
    public int Change(int amount, int[] coins)
    {
        int columns = amount + 1;

        int[] dp = new int[columns];

        // Fill first element with 1
        dp[0] = 1;

        for (int i = 0; i < coins.Length; i++)
        {
            for (int j = 1; j < columns; j++)
            {
                if (j >= coins[i])
                {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[columns - 1];

    }
} 