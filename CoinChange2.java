public class CoinChange2
{
    class Solution {
        public int changeDP(int amount, int[] coins)
        {
            int denominationsRows = coins.length+1;
            int amountColumns = amount+1;
            int[][] dp = new int[denominationsRows][amountColumns];

            dp[0][0] = 1;
            for(int i = 1; i < denominationsRows; i++)
            {
                for(int j = 0; j < amountColumns; j++)
                {
                    if(j < coins[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
            return dp[denominationsRows-1][amountColumns-1];
        }
        public int changeRecursive(int amount, int[] coins)
        {
            return helper(coins, 0, amount);
        }

        public int helper(int[] coins, int idx, int remainingAmount)
        {
            // base
            if(remainingAmount == 0)    return 1;
            if(remainingAmount < 0) return 0;
            if(idx >= coins.length) return 0;

            // logic
            int choose = helper(coins, idx, remainingAmount-coins[idx]);
            int notChoose = helper(coins, idx+1, remainingAmount);

            return (choose+notChoose);
        }
    }
}
