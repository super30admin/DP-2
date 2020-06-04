// This is the recursive brute force solution for coin change. Similar to minimum coins but instead of storing minimums we store the number of possibilities. 
//Time complexity: O(2^n)
//Space complexity:O(1)

//WIll be optimized in the dp solution

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        if(amount ==0 && coins.length==0) return 1;
        return helper(coins,amount,0);
    }
    
    public int helper(int[] coins,int amount,int index){

        if(amount==0) return 1;
        if(amount < 0 || index==coins.length) return 0;

        int case1=helper(coins,amount,index+1);
        int case2=helper(coins,amount-coins[index],index);
        return case1 + case2;
    }
    
}