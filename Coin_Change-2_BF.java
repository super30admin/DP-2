// 518. Coin Change 2 - https://leetcode.com/problems/coin-change-2/
// Time Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes with Time Limit Exceeded
// Any problem you faced while coding this : Time Limit Exceeded

class Solution {
    public int change(int amount, int[] coins) 
    {
        if(coins == null || coins.length == 0)
            return 0;
        
        return helper(coins, amount, 0);
    }
    
    private int helper(int[] coins, int amount, int index)
    {
        // base
        if(amount == 0) return 1;
        
        if(amount < 0 || index == coins.length) return 0;
        
        // logic
        //choose
        int case1 = helper(coins, amount - coins[index], index);
        
        // dont choose
        int case2 = helper(coins, amount, index+1);
        
        return case1+case2;
    }
}