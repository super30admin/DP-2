// Time Complexity : O(n+m)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length + 1;
        int n = amount + 1;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                int withVar = j - coins[i-1] > -1 ? dp[i][j-coins[i-1]]: 0;
                int withoutVar = dp[i-1][j];
                dp[i][j] = withVar + withoutVar;
            }
        }
        return dp[m-1][n-1];
    }
}