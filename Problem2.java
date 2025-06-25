// Time Complexity : O(coins.length∗amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class Problem2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int c : coins)
            for(int i = c; i <= amount; i++)
                dp[i] += dp[i - c];
        return dp[amount];
    }
}
