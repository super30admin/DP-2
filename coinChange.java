// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Develop a DP table with values for each sub tree. 
 * Add the top element and left element to get number of occurances for a possible subtree. 
 * If denomination is lesser than coin, return value at the top element only. 
 * Return the value stored at the last for all occurances possible.
 */

class coinChange {
    public int change(int amount, int[] coins) {
        int m =coins.length;
        int n =amount;
        int[] dp= new int[n+1];
        dp[0] =1;
        for(int i=1;i<=m;i++){
            for(int j=0; j<=n;j++){
                if(j<coins[i-1])
                dp[j]=dp[j];
                else
                dp[j]=dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[n];
    }
}