// Time Complexity : O(mn) where m = length of coins array, n = amount
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First we try greedy solution and see that it does not always give optimal solution
// So we will need to exhaustive search. In doing so we see that there are repeated subproblems so we can optimize using DP
// dp[m][n] gives us the no of ways we can we can form the amount m given the coins with indexes 0 to n

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 1;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        return dp[m][n];
    }
}