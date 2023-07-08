public class CoinChange2ReturnAllWays {
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Solution using 2D array
    class Solution1 {
        public int change(int amount, int[] coins) {
            int m = amount;
            int n = coins.length;
            if(coins==null) return 0;
            int[][] dp = new int[n+1][m+1];
            dp[0][0]=1;

            for(int i=1; i<=n; i++){
                for(int j=0; j<=m; j++){
                    if(j<coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else { // here we need to return the all possible ways so we need to add
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    }
                }
            }
            return dp[n][m];
        }
    }
// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Optimize  solution using 1D array
    class Solution2 {
        public int change(int amount, int[] coins) {
            int m = amount;
            int n = coins.length;
            if(coins==null) return 0;
            int[] dp = new int[m+1];
            dp[0]=1;

            for(int i=1; i<=n; i++){
                for(int j=0; j<=m; j++){
                    if(j<coins[i-1]){
                        dp[j] = dp[j];
                    }
                    else { // here we need to return the all possible ways so we need to add
                        dp[j] = dp[j] + dp[j-coins[i-1]];
                    }
                }
            }
            return dp[m];
        }
    }
}
