// Time Complexity : O(M * N)  (M -> amount ,N -> coins length)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Line 1: Initialize a DP array and set Set dp[0] = 1. Loop through amounts from 0 to the target amount. 
// Line 2: If the current amount is divisible by the first coin, set dp[i] = 1 for that amount, 
//         as we can directly form this amount using the first coin.
// Line 3: Now For each coin, update dp[i] for all amounts i >= coin, adding dp[i - coin] to dp[i], 
//         because dp[i - coin] represents the ways to form the remaining amount after using the current coin.
// Line 4: After processing all coins, return dp[amount], which gives the number of ways to make the target amount.

public class CoinChange2 
{
    public int change(int amount, int[] coins) 
    {
        int[] dp = new int[amount+1];
        //First Coin
        for(int i=0;i<amount+1;i++)
        {   
            if(i==0){ dp[0] = 1; }
            else if(i%coins[0]==0){ dp[0] = 1; }
        }   

        //Remaning Coin
        for(int j=0;j<coins.length;j++)
        {
            for(int i=1;i<amount+1;i++)
            {
                if(i>=coins[j])
                {
                    int x = i-coins[j];
                    dp[i] = dp[x]+ dp[i];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange = new CoinChange2();
        int[] coins = {1, 2, 5};  
        int amount = 5; 
        int result = coinChange.change(amount, coins);
        System.out.println(result); 
    }
}