// DP Approach
// Form a matrix to store probalble summation solutions from the denominations.
// Check for number of probable solutions by adding the number of previous coins used plus the Denomination before the same case occured 
// Fill the matrix and the last value will give you the no of ways denominations could be used to get to the solution.

// Time Complexity O(m*n) 
// Space Complexity O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<dp.length;i++){
            for(int j = 1; j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j]; 
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}