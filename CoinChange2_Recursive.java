// Time Complexity : O(2^NK) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        return helper(amount, coins,0);
    }
    private int helper(int amount, int[] coins, int i){
        if(amount == 0 ) return 1;
        if(amount<0 || i == coins.length) return 0;
        
    
        int case1 = helper(amount-coins[i],coins,i);
        int case2 = helper(amount, coins,i+1);
        return case1+case2;
    }
}