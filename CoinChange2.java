/**
Problem: Find the number of ways in which we can make the required amount given infinite supply of some coin denominations.

Time Complexity: O(A*n), where A is the amount needed and n is the number of coins
Space Complexity: O(A*n), as we use a matrix of size A * n, where A is the amount needed and n is the number of coins
Did this code successfully run on Leetcode : Yes

Approach : Dynammic Programming.
1. Create a matrix where the rows are the denominations of coins that are available to us, and columns are the amounts from 0 to A.
2. The number of ways to make amount 0 with 0 coins is 1, with 0&1 is 1, so similarly we fill the dp table dp[i][0] = 1
3. The number of ways to make any amount(other than 0) with 0 coins is 0. dp[0][j] = 0
4. At each cell, we add the number of ways in which it's possible to reach the amount with earlier available coins
plus the number of ways in which it's possible to reach the target amount with the present coin.
4. This way, we compute the whole matrix, and the total number of combinations needed is present in the last cell of the matrix.
*/



class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}