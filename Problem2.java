// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Memoization to compute the number of ways to make up the amount



class Solution {
    public int change(int amount, int[] coins) {
        
        // TC: O(mn)
        // SC: O(mn)
        
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(j >= coins[i-1]) {
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
        
    }
}