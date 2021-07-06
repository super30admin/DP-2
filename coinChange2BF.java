// Time Complexity : O(2^(m+n))
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        //base case in case the array is empty
        if(coins == null || coins.length == 0)
            return 0;
        
        //index is 0 to begin with
        return helper(coins, amount, 0);
    }
    
    private int helper(int[] coins, int amount, int index){
        //base case: if amount is 0 it means we have found a path
        if(amount == 0)
            return 1;
        //base case: if index is out of bounds or amount becomes less than 0, it is not a valid path
        if(amount < 0 || index >= coins.length)
            return 0;
        
        //logic
        //choose the coin at the index
        int case1 = helper(coins, amount - coins[index], index);
            
        //dont choose that denomination
        int case2 = helper(coins, amount, index + 1);
        
        return(case1 + case2);
            
    }
}