// Time Complexity : O(n*m) n: number of coins  m: the amount
// Space Complexity : O(m)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int []dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++)  
        {
            for(int j=coins[i];j<amount+1;j++)  // for each amount upto the given amount determine the ways in which the a coin can be used to build that amount  
            {
                dp[j]+=dp[j-coins[i]];
            }
        }
        
        return dp[amount];
    }
}