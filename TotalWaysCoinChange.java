// TIME: O(nk) where n is amount and k is coins array length
// SPACE: O(nk)
// SUCCESS on LeetCode

public class TotalWaysCoinChange {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int a = 1; a < dp[0].length; a++) {
            for (int c = 1; c < dp.length; c++) {
                if (a < coins[c-1]) {
                    dp[c][a] = dp[c-1][a];
                } else {
                    dp[c][a] = dp[c-1][a] + dp[c][a-coins[c-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}
