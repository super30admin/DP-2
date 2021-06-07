// Time Complexity:  Exponential as at each stage we will make 2 decisions

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        return helper(amount, coins, 0);
    }
    
    private int helper(int amount, int[] coins, int index){
        
        /* base code */
        //valid case
        if(amount==0) return 1;
        if(amount < 0 || index == coins.length) return 0;
        
        
        /*logic code*/
        //choose coin
        int case1 = helper(amount - coins[index], coins, index);
        //not choose coin
        int case2 = helper(amount, coins, index+1);
        
        //return code
        return case1+case2;
    }
}