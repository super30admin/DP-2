// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
    // n is the given types of coins
    // m is the total amount required

// Your code here along with comments explaining your approach
    //We use 2D-Array to store the least number of coins required to reach an amount with a particular set of coin denominations. We initialize the first row (the number of zero denomination coins required to reach any amount) with one.
    //At each iteration with a given set of coin denominations, we find the total number of ways possible to reach all the amounts from 0 to the given amount. We do that by adding the ways possible by using the new coin denomination and without using it.
    //After we get all the optimal solutions with a set of coin denominations, we consider one more coin to be in the set. In this way, we keep adding all the coins one by one in to the set. 
    //We keep track of all the optimal solutions at every situation in the "dp array", where each row depicts a set of coin denominations, and each column depicts required amount.

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length+1;
        int m = amount+1;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i=1; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int currentCoin = coins[i-1];
                int amountLeft = j;
                if (currentCoin>amountLeft)
                {
                    //copy from above
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    //consider both current coin denomination way and all the ways until now
                    dp[i][j] = dp[i-1][j] + dp[i][j-currentCoin];
                }
            }
        }
        //total number of ways coins can be used to get amount
        return dp[n-1][m-1];
    }
}