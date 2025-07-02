// Time Complexity: O(n * k), n is number of coins and k is amount
// Space Complexity: O(n * k), n is number of coins and k is amount

// Use a dp array to memoiz the total ways to get j target amount with i different kinds of coins

class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;

        int dp[][] = new int[coins.length+1][amount+1];

        for(int i=0; i<coins.length+1; i++) {
            dp[i][0] = 1; // for amount 0, there is only 1 way to make it
        }

        for (int i=1; i<coins.length+1; i++) {
            for(int j=1; j<amount+1; j++) {
                // not choose current coin
                int case0 = dp[i-1][j];
                // choose current coin
                int case1 = 0;
                if (j >= coins[i-1]) {
                    case1 = dp[i][j-coins[i-1]];
                }

                int totalWays = case0 + case1;
                dp[i][j] = totalWays;
            }
        }


        // return the number of ways at target amount with all coins available
        return dp[coins.length][amount];
    }
}
