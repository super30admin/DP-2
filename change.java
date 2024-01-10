class Solution {
    public int change(int amount, int[] coins) {
        //Tc: O(m*n) Sc: O(m*n)
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1 ; i < dp.length; i++)
        {
            for(int j = 0 ; j < dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp [i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}


/*
   return helper(coins, amount,0);
        
    }

    private int helper(int[] coins, int amount, int index)
    {
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;

     //choose coin
     int case1 = helper(coins, amount-coins[index],index);
     //not choose coin
     int case2 = helper(coins, amount,index+1);
     return case1+case2;
*/