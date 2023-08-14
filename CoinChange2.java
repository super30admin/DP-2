// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes

class CoinChange2{
public int change(int amount, int[] coins) {
        // null case
        if(coins == null) return 0;
        
        int n = coins.length;
        int m = amount;
        dp[][] = dp[n+1][m+1];
        dp[0][0] = 1; // Filling first element row with 1. Given that if amount is zero return 1.

        for(int i = 1; i<= n; i++){
            for(int j = 0; j<= m; j++)
            // Zero case -- 
                if(j < coins[i-1]){  // If coin is bigger than the denimination. then its invalid case, just take previous column.
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j- coins[i-1]]
                }
        }
        return dp[n][m];
    }

}