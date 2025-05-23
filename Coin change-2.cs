/*
  Time complexity: O(m*n)
  Space complexity: O(n)

  Code ran successfully on Leetcode: Yes

  Approach: The number of ways at any instant is the sum of the ways not using the coin and using it. On using the choice we caclculate the difference between the amount and current coin.

*/

public class Solution {
    public int Change(int amount, int[] coins) {
        int n = amount;
        int[] dp = new int[n+1];
        dp[0]=1;

        foreach(int coin in coins)
        {
            for(int j=coin;j<=n;j++)
            {
                dp[j]+=dp[j-coin];

            }
        }
        return dp[n];
    }
}
