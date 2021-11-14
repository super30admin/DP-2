// Time Complexity : O(m*n) where m = number of coins + 1  , n = amount + 1
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// first fill the innitail column with 1, then till the value of amount is less then coin copy the dp value from one above it. then set the dp value by adding the value above it plus coin number of steps away from it.
// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null || coins.length == 0) return 0;
        int [][] dp = new int [coins.length + 1][amount+1];
        // inserting the initial values
        for( int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }
        // going throght the top and previous index value
        for(int i = 1; i < coins.length+1 ; i++){
            for( int j = 1; j < amount+1; j++){
                if( coins[i-1] > j){
                    dp[i][j] = dp [i-1][j];
                }else{
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}