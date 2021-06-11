// Recuraive Solution

// Time Complexity : O(2^n) n -> no. of coins 
// Space Complexity : Same as above
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I forgot 2 conditions. (i) || total < 0 (ii) in variable take index remains as it is. I did index+1.

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        return helper(coins, 0, amount);
    }
    
    private int helper(int[] coins, int index, int total){
        //base
        if(index >= coins.length || total < 0)
            return 0;
        if(total == 0)
            return 1;
        //logic
        int take = helper(coins, index, total-coins[index]);
        int skip = helper(coins, index+1, total);
        return take+skip;
    }
}


// DP Solution

// Time Complexity : O(nxm) n -> coins array; m -> amount
// Space Complexity : Same as above
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : had used coins[i-1] < j then debugged to correct it to coins[i-1] > j

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<dp.length; i++)
            dp[i][0] = 1;
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];  
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];   
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
