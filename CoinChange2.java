public class CoinChange2 {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i=1; i<=n; i++){
            for (int j=0; j<=m; j++){
                //till demom > amount -> 0 case
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][m];
    }

    // Time: O(2^(m+n))
    // public int change(int amount, int[] coins) {
    //     return helper(amount, coins, 0);
    // }
    // public int helper(int amount, int[] coins, int index){
    //     //base
    //     if (amount < 0 || index == coins.length) return 0;
    //     if (amount == 0) return 1;
    //     //logic
    //     int case0 = helper(amount, coins, index+1);
    //     int case1 = helper(amount- coins[index], coins, index);

    //     return case0 + case1;
    // }
}
