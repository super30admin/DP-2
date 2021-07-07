// Time Complexity :O(m2^n) where n is the length of the coins array and m is the amount.
// Space Complexity :O(nm) n where n is the length of the coins array and m is the amount.
// Did this code successfully run on Leetcode :No - Time Limit Exceded.
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach 

//Brute Force Approach


class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount,coins,0);
        
    }
    
    private int helper(int amount, int[] coins,int index)
    {
        //base case
        if(amount == 0) return 1;
        if(index>=coins.length || amount<0) return 0;
        
        //logic
        int case1 = helper(amount, coins, index+1);
        int case2 = helper(amount-coins[index],coins,index);
        return case1 + case2;
    }
    
}