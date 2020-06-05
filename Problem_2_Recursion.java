// Time complexity - O(2^n)
// Space complexity - O(n)... because of recursive stack?

// Implemented using recursion. 


class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount );
    }
    
    int helper(int[] coins, int index, int amount){
        if(amount < 0){
            return 0;
        }else if(amount == 0){
            return 1;
        }else if(index >= coins.length){
            return 0;
        }
        
        int case1 = helper(coins, index, amount-coins[index]);
        int case2 = helper(coins, index+1, amount);
        
        return case1+case2;
    }
}
