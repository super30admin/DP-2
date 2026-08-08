// Approach - Recursion can be used to pursue exhaustive path, but since this problem has repeated sub problems
// we could use Dynamic programming.
// Time Complexity - O(mxn)
// Space Complexity - O(mxn)

class CoinChange2 {
    public int change(int amount, int[] coins) {

        //Validate the inputs
        if(coins == null || coins.length == 0){
            return 0;
        }

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    // No choose + choose scenario where we need to subtract the chosen denomination from the amount to construct previous case to get the corresponding value
                    dp[i][j] = dp[i-1][j] + (dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[m][n];
    }
}