// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        //check base case if the array is empty
        if(coins == null || coins.length == 0)
            return 0;
        
        //we make a matrix with sizes one more than the amount and coins length since they might be 0 at some point
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        //first column is 1 because that is the only way to return 0 as amount
        for(int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;
        
        //loop through all the coins
        for(int i = 1; i <= coins.length; i++)
            //loop through all the amounts
            for(int j = 1; j <=amount; j++)
                //amount is less than the coin we have so we just return the previous row's amount
                if(coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                //otherwise we return the top box plus the box coin steps before the current
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
        
        //we return the very last box
        return dp[coins.length][amount];
    }
}