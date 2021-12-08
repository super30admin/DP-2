// Time Complexity : n = rows = coins.length & m = coulmn = amount O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        
        int dp [][] = new int[coins.length+1][amount+1];
        
        for(int i = 0  ; i < coins.length +1 ; i++)
            dp[i][0] = 1; // 0 amount can be made by not selecting any coins i.e no of coins 0 
    
        for(int i = 1; i < coins.length+1 ; i ++)
        {
            for(int j = 1 ; j < amount+1 ; j++)
            {
                if(j < coins[i-1]) // only 1 way of not selecting as selecting causes -ve value
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}

//recursive
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        return helper(coins, amount, 0);
    }

    private int helper(int []coins, int amount, int idx)
    {
        // base case
        if(amount == 0)
            return 1;
        if(amount < 0 || idx == coins.length)
            return 0;

        // recursive case
        int case0 = helper(coins, amount, idx+1);
        int case1 = helper(coins, amount - coins[idx], idx);

        return case0+case1;
    }
}