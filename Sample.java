// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null && coins.length == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        int m = dp.length;
        int n = dp[0].length;
        dp[0][0] = 1;
       
        for(int i=1;i<m;i++) {
            dp[i][0] = 1; 
        }
        
         for(int i=1;i<n;i++) {
            dp[0][i] = 0; 
        }
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
       return dp[m-1][n-1]; 
        
        // return helper(amount, coins, 0);
    }
    
    private int helper(int amount, int[] coins, int index) {
        //Base case:
        if(index == coins.length || amount < 0) {
            return 0;
        }
        
        if(amount == 0) {
            return 1;
        }
        //Recursion:
        // Choose
        int case1 = helper(amount - coins[index], coins, index);
        
        // Not choose
        int case2 = helper(amount, coins, index+1);
        return case1 + case2;
    }
}
