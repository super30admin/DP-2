// Time Complexity : O(mxn) 
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        //base
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for(int i = 1 ;i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){       
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[n][m];
    }
}

/* Recursive approach 
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        return helper(coins, amount, 0);
    }
    private int helper(int[] coins, int amount, int i){
        //base
        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        //Choose the coin
        int case1 = helper(coins, amount-coins[i], i);
        //Not choose the coin
        int case2 = helper(coins, amount, i+1);
        return case1 + case2;
    }
}
*/