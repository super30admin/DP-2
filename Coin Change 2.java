
// Time Complexity : O(m*n) where m = amount and n = number of coin denominations
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        // check for coins array to be null or empty
        if(coins == null || coins.length == 0) return 0;
        
        int [][]dp  = new int [coins.length + 1][amount + 1];
        
        // fill the first column of dp matrix with 1
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][0] = 1;
            }
        }
        
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                // for each cell of matrix, check amount is less than denomination of coin
                if(j < coins[i - 1]){
                    // if the amount is less than denomination of coin,
                    // then fill the element with value of element just above
                    dp[i][j] = dp[i-1][j];
                }else{
                    // else the previous row element + element in the same row, demonination col to the left
                     dp[i][j] = dp[i-1][j] +  dp[i][j - coins[i-1]];
                }
            }
        }
        
        // return the last element of the dp matrix
        return dp[dp.length - 1][dp[0].length - 1];
    }
}