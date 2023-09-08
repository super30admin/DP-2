/*

Problem2 (https://leetcode.com/problems/coin-change-2/)

Time Complexity : O(n*k)
Space Complexity : O(n*k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


 */


 // Approach Using DP

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null){
            return 0;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

// Approach using recursive

//Time Complexity : O(2^(n+k))
//Space Complexity : O(1)


class Solution_1 {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null){
            return 0;
        }

        return recurse(coins, amount, 0);
    }

    private int recurse(int[] coins, int amount, int index){
        if(amount < 0 || index == coins.length){
            return 0;
        }

        if(amount == 0){
            return 1;
        }

        int case1 = recurse(coins, amount, index + 1);
        int case2 = recurse(coins, amount - coins[index], index);

        return case1 + case2;
    }
}