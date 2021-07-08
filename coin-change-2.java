class Solution {
    public int change(int amount, int[] coins) {
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        int dp[][] = new int[coins.length+1][amount+1];
        // first column
        for (int i=0; i<=coins.length; i++)
            dp[i][0] = 1;
        
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                // amount < denomination
                if (j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        
        return dp[coins.length][amount];
    }
}