//BRUTE FORCE  no of ways is my output
class Solution {
    public int change(int amount, int[] coins) {
     
        int index = 0;
        return helper(amount,coins,index);
    }
    
    private int helper(int amount,int[] coins,int index){
        //base based on increasing and decreasing parameters
        if( amount == 0 ) return 1; // 1 valid case
        if( amount < 0 || index == coins.length ) return 0;
        
     
        //logic
        // choosing
        int case1 = helper(amount-coins[index],coins,index);
        //not choosing
        int case2 = helper(amount,coins,index +1);
        
        //all possible ways
        return case1+case2;
    }
}

/*
TimeComplexity O(m x pow(2,n) ) m is amount and n is no of coins
Space Complexity O(1)
*/

