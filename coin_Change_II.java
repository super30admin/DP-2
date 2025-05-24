// Time Complexity : O(amount * coins.length)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j<= n; j++){
                if(j < coins[i-1]) dp[j] = dp[j];
                else{
                    dp[j] = dp[j- coins[i-1]] + dp[j];
                }
            }
        }

        return dp[n];
    }
}
