// Recursive Solution


// Time Complexity : O(Amount/Min(coins))
// Space Complexity : O(Amount/Min(coins))
// Did this code successfully run on Leetcode : yes but TLE
// Any problem you faced while coding this : none


class Solution {
    int count = 0;
    
    public int change(int amount, int[] coins) {
        if((coins==null || coins.length == 0) && amount == 0) // this condition is for a particular edge case
            return 1;
        helper(coins, amount, 0);
        return count;
    }
    
    private void helper(int[] coins, int amount, int index){
        if(index>=coins.length || amount<0) return;
        if(amount==0){ 
            count++;
            return;
        }
        
        helper(coins, amount, index+1);
        helper(coins, amount-coins[index], index);
    }
}


// DP Solution

// Time Complexity : O(n*(amount+1))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        
        // initializing base case
        dp[0] = 1;
        
        for(int i=0; i<coins.length; i++){
            for(int j=1; j<dp.length; j++){
                if(j>=coins[i])
                    dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        
        return dp[amount];
    }
}