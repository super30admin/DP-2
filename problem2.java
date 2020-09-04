//Time Complexity= O(N^2)
//Space Complexity =O(N^2)
class Solution {
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        // start it from 1 as we have already initilased dp[0][0]=0
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    // Copy value from top
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // go coins steps back plus 1 OR TOP
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

                }

            }
        }

        return dp[coins.length][amount];
    }
}