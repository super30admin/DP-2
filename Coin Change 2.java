// time - mn
// space - mn

//dp
class Solution {
    public int change(int amount, int[] coins) {

        if(coins.length == 0) return 0;

        int[][] dp = new int[coins.length+1][amount+1];

        dp[0][0] = 1;

        for(int i=0 ; i<=coins.length ; i++)
        {
            for(int j=0 ; j<=amount ; j++)
            {
                if(i==0 && j>0) dp[i][j] = 0;

                else if(j==0) dp[i][j] = 1;

                else if(j < coins[i-1]) dp[i][j] = dp[i-1][j];

                else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        return dp[coins.length][amount];

    }
}


//recursive
class Solution {
    public int change(int amount, int[] coins)
    {

        if(coins.length == 0) return 0;

        return helper(coins , amount , 0);

    }

    private int helper(int[] coins , int amount , int index)
    {
        // base case

        if(amount == 0) return 1;

        if(index == coins.length || amount<0) return 0;

        // recursive case

        // choose

        int ways1 = helper(coins , amount-coins[index] , index);

        // not choose

        int ways2 = helper(coins , amount , index+1);

        return ways1+ways2;

    }
}
