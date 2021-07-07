// Time Complexity : O(n*m), n is number of coins and m is amount. 
// It is psuedo polynomial as m is a number. 
// Space Complexity : O(m), m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; //to get +1 if amount = coin
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i]) { //if current amount is >= current coin
                    dp[j] += dp[j - coins[i]]; 
                    //current # ways + new ways (new ways : amount - coin value : will give us the # ways we can change the remainder value after giving the current coin)
                }
            }
        } return dp[amount];       
    }
}


