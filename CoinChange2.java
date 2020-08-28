// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Understanding DP


// Your code here along with comments explaining your approach
class Solution {
    public int change(int n, int[] coins) {
        if(n==0 && coins.length==0) 
            return 1;
        
        if(coins.length==0) 
            return 0;
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=n; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[n];
    }
}