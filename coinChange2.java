// Time Complexity = O(n*amount)
// Space Complexity = O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        // Case 1: First colomn - We assign the value 1 to each row since there is only one way to choose 0 amount, which is to not choose the coin
        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        // Case 2: First row - We assign the value 0 to each element of 0th row since there is no way (0 ways) to form the amount with a 0 valued coin.
        for (int i=0; i<=amount; i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=amount; j++) {
                // Case 3: Coin value is more than the amount, we cant choose it to form the amount, so in that case we get the amount from the previous row.
                if (coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // Case 4: In all the other elements where we can choose the coin, we will add the cases where we choose and dont choose the coin.
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        // Return the final block of the 2D array, it will have the maximum number of ways to choose an amount
        return dp[n][amount];
    }
}