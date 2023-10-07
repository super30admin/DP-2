/* Time Complexity : O(m*n) - Matrix
 * 	m - length of the input array - coins
 *  n - amount*/
/* Space Complexity : O(n)
 *  n - amount */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


public class CoinChangeCombination {
	public int change(int amount, int[] coins) {
        if(coins == null) return 0;

        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                // amount is less than the coin denomination
                if(j < coins[i-1]){
                    //previous row
                    dp[j] = dp[j];
                }else{
                    //previous row (same column) + (same row) curr. amt - denomination of the coin
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}


/*

/* Time Complexity : O(m*n) - Matrix
 * 	m - length of the input array - coins
 *  n - amount*/
/* Space Complexity : O(m*n)
 * 	m - length of the input array - coins
 *  n - amount */

//Matrix solution
/*

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1; i <= m; i ++){
            for(int j = 0; j <= n; j++){
                // amount is less than the coin denomination
                if(j < coins[i-1]){
                    //previous row
                    dp[i][j] = dp[i-1][j];
                }else{
                    //previous row (same column) + (same row) curr. amt - denomination of the coin
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
*/


/*
 
 /* Time Complexity : O(2^(m+n))
 * 	m - length of the input array - coins
 *  n - amount*/
/* Space Complexity : O(m*n)
 
 
//Exhaustive solution
 
 class Solution {
 
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        return helper(coins, 0, amount);
    }
    private int helper(int[] coins, int index, int amount){
        //base case
        if(amount == 0) return 1;
        if(amount < 0 || index >= coins.length) return 0;

        //When we choose the coin
        int case1 = helper(coins, index, amount - coins[index]);
        //When we do not choose the coin
        int case2 = helper(coins, index + 1, amount);

        return case1 + case2;
    }
}*/