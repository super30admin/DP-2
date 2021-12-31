// Time Complexity : O(n * m) where n is the number of different denominations
//                and m is the amount
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Followed approach of dp taught yesterday in class where in we try to find
 results based on what we saw previous, here for finding number of ways I add
 from the prvious row and when the same coin was used that means when it was
 cosen and not chosen but there is a guarantee that when amount is equal to
 denomination there is for sure one solution*/

class CoinsChangeII
{
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[coins.length+1][amount+1];

        return helper(dp, amount, coins, 0);
    }

    public int helper(int[][] dp, int amount, int[] coins, int total){

        if(amount == 0) return 1;

        for(int row = 1; row < coins.length + 1; row++)
        {
            for(int col = 1; col <= amount; col++){
                if(coins[row-1] > col){
                    dp[row][col] = dp[row-1][col];
                }
                else{
                    dp[row][col] = dp[row-1][col] + dp[row][col - coins[row-1]];
                }
                if(coins[row-1] == col) dp[row][col] += 1;
            }
        }

        return dp[coins.length][amount];
    }
}
