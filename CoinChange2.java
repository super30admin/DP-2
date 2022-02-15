/**

Top Down with memoization.
TC - O(m*n) where m is the number of coins. and n is the total amount. So total m*n unique problems can be found.
SC - O(m*n) where m is the number of coins. and n is the total amount. This space is being used for memoization.




**/
class Solution {
    
    int dp[][];
    
    public int change(int amount, int[] coins) {
        
        dp = new int[coins.length][amount + 1];
        
        for (int i=0; i<coins.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        
        return coinChangeHelper(coins, amount, 0);
    }
    
    public int coinChangeHelper(int coins[], int amount, int index)
    {
        // base conditions
        if (amount == 0)
        {
            return 1;
        }
        
        if (amount < 0 || index == coins.length)
        {
            return 0;
        }
        
        if (dp[index][amount] != -1)
        {
            return dp[index][amount];
        }
        
        int chooseTheIndex = coinChangeHelper(coins, amount - coins[index], index);
        int notChooseTheIndex = coinChangeHelper(coins, amount, index + 1);
        
        int numberOfWays  = chooseTheIndex + notChooseTheIndex;
        
        dp[index][amount] = numberOfWays;
        
        return numberOfWays;
    }
}