// This algorithm divides the whole space into overlapping sub problems with choose and no choose scenarios and arrives at the final use case of getting total wyas to arrive at amount
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i=1;i<=coins.length;i++) {
            for(int j=0;j<=amount;j++) {
                // Unable to choose the existing coin
                if(coins[i-1]>j) {
                    dp[j] = dp[j];
                // Choosing existing with sub problem for choosing remaining plus not choosing existing
                } else {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
