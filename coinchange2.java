// Time Complexity : O(n*k) where n is amount and k coins
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[] = new int[amount+1];
        
        dp[0]=1;
        
        for(int i = 0;i<coins.length;i++) {
            
            for(int j=coins[i];j<=amount;j++) {
                
                // compute ways if use current coin + previous ways
                dp[j] = dp[j] + dp[j-coins[i]];
                
            }
            
        }
        
        return dp[amount];
    }
}
