// Time Complexity : O(n. m), n = size of coins array, m = amount 
// Space Complexity : O(m), m = amount 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i])
                    dp[j] = dp[j - coins[i]] + dp[j];
            }
        }
        return dp[amount];
    }
}
