// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// the below solution consists of matrix
// assume it like rows - every denomination and cols - every possible amount
// now in 1D, we overwrite with new values
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=1;i<=amount;i++) {
            dp[i]=0;
        }
        for(int i=1;i<=coins.length;i++) {
            for(int j=0;j<=amount;j++) {
                if(j< coins[i-1]) dp[j]=dp[j];
                else dp[j] = dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[amount];
    }
}

// Your code here along with comments explaining your approach
