/*
T.C O(m*n)
S.C O(n) For array based DP
S.C O(m*n) for matrix based DP
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/coin-change-ii/description/
// Any problem you faced while coding this : -
 */

//Make use of stored sub problem solutions to find the final answer
public class CoinChange2DP {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1])
                    dp[j] = dp[j];
                else {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];

    }
}
