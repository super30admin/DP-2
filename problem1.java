// Time Complexity : O(M*N)
// Space Complexity : )(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        //fill the first row
        for(int i=0; i<= coins.length; i++)
            dp[i][0] = 1;
        
        for(int i=1; i<= coins.length; i++){
            for(int j=1; j<=amount; j++){
                
                //amount denomination
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else 
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        
        return dp[coins.length][amount];
    }
}
