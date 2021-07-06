// Time Complexity : O(M*N) M-> No of Coins and N-> Amount
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int change(int amount, int[] coins) {     

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
            }

        }
        return dp[coins.length][amount];
    }
} 