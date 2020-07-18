/**
LeetCode Submission : Time Limit Exceed (Because of recursion)
Space Complexity : O(2^N)
Time Complexity : O(2^N)
Use similar logic from previous problem once we enounter a solution i.e. amount = 0 add 1 to final possible solution
**/

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        
        if(coins.length < 0)
            return 1;
        
        return decision(amount,coins,0);
        
    }
    
    int decision(int amount, int[] coins, int i){
        if(amount == 0)
            return 1;
        
        if(amount < 0 || i >= coins.length)
            return 0;
        
        return decision(amount-coins[i],coins,i) + decision(amount,coins,i+1);
    }
    
}
