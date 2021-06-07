// Time Complexity : O(2 pow (m + n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        //null case
        if(coins.length == 0 || amount == 0)
            return 0;
        return helper(amount,coins,0,0);
    }
    
    private int helper(int amount, int[] coins, int index, int result){
        //base case
        if(result == amount)
            return 1;
        if(result > amount || index > coins.length -1)
            return 0;
        //chose the coin
        int case1 = helper(amount,coins,index,result + coins[index]);
        //do not chose the coin
        int case2 = helper(amount,coins,index + 1,result);
        
        return case1 + case2;
    }
}