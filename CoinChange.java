// Time Complexity : 0(mn)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class CoinChange {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;

        int [] dp = new int[amount+1];
        for(int i=1; i<=coins.length; i++) {
            dp[0] = 1;
            for(int j=1; j<=amount; j++) {
                if(j >= coins[i-1]) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}