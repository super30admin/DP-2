// Time Complexity : O(m*n) m is no.of coins and n is amount
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int change(int amount, int[] coins) {
        //edge case
        if(coins == null)
            return 0;
        int[][] dp = new int [coins.length + 1][amount + 1];
        
        for( int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        
        for( int i = 1; i < dp.length; i++){
            for( int j = 1; j < dp[0].length; j++){
                if( j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length -1][dp[0].length - 1];
    }
}


// Brute force solution O(2 power n)
/*
class Solution {
    public int change(int amount, int[] coins) {
        //edge case
        if(coins == null)
            return 0;
        return helper(coins, amount, 0);
    }
    
    private int helper(int[] coins, int amount, int index){
        //base case
        if(amount == 0 )
            return 1;
        if(amount < 0 || index == coins.length)
            return 0;
        //logic
        //choose coin
        int case1 = helper(coins, amount-coins[index], index);
        //dont choose coin
        int case2 = helper(coins, amount, index+1);
        return case1 + case2;
        
    }
}
*/