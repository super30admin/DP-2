// Time complexity : O(m*n)

// Space complexity : O(n)

// Approach: We used a bottom up dynamic programming approach to solve repeated sub problems using the exhaustive approach. We took a 2D array of the two contraints where the rows are the coins (we added a 0th row as a dummy row and a 0th column as a dummy column) and the columns are the amounts in increasing order from 0 to amount. 

//Here the 1D array stores the total number of ways to get to a certain amount using available coins. Each array index represents an amount and the value at the index represents the number of ways to get to that amount 

// We can optimize space further by only using 1D array as we only need previous and current row.


class Solution {
    public int change(int amount, int[] coins) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i-1]) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        
        return dp[amount];
    }
}