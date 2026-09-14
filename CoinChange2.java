// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int [] dp = new int[m+1];
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                // not choose
                if(j < coins[i-1]){
                    dp[j] = dp[j];
                } else{
                    // choose
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }

        return dp[m];
    }
}