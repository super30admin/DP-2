// Time Complexity : O(mn)
// Space Complexity : 0(n) - Optimized space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class CoinChangeII {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        //By default initiated with 0
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //till current amount < denominations
                if(j < coins[i - 1]){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}