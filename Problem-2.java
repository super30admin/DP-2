// Time complexity: O(m*n)
// Space Complexity: O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// recursive way . runs successfully but Time limit exceeded
//Time complexity: O(2^n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
       return helper(amount, coins, 0); 
    }

    private int helper(int amount, int[] coins, int idx) {

        if(amount == 0) return 1;
        if(idx == coins.length || amount < 0) return 0;

        // not choose case
        int case1 = helper(amount, coins, idx+1);

        //choose case
        int case2 = helper(amount-coins[idx], coins, idx);

        return case1 + case2;
    }
}

// DP solution
// Time complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;

        int m = coins.length; //rows = no of coins
        int n = amount; //columns = amount
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i =1; i<=m; i++) {
            for(int j =0; j<=n; j++) {

                //if denomination of coin > amount
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                   dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                }
            }
        }

        return dp[m][n];
    }
}