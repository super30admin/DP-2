// Time Complexity : O(N*amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
                if(amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1; 
        for(int i = 0; i < coins.length; i++)
        {
            for (int j = 0; j < amount + 1;  j++)
            {
            if(j-coins[i] >=0)
            {
                dp[j]= dp[j] + dp[j-coins[i]];
            }
            }
        }
        
        
        return dp[amount];
    }
}
// Your code here along with comments explaining your approach
