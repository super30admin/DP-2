// Time Complexity : O(m * n), m = amount + 1, n = coins.length + 1
// Space Complexity : O(m * n), m = amount + 1, n = coins.length + 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took time to come up with the solution. 
// Thinking about the first condition was also intuitive.


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length + 1][amount + 1]; 
        
        for(int i = 0; i <= coins.length; i++) dp[i][0] = 1;
        for(int j = 1; j <= amount; j++) dp[0][j] = 0;
        
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                // when the value of j < coin denomination
                // copy the value as it is from
                // above row and same column
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // add the previous row and same column value
                    // to the condition where you subtract the 
                    // column with the coin denomination to 
                    // reach the required possible value
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}