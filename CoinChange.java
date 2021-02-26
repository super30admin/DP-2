// Time Complexity - O(m X n)
// Space Complexity - O(m X n)


class Solution {
    public int change(int amount, int[] coins) {
        // Initializing n and m 
        int n = amount + 1;
        int m = coins.length + 1;
        // Create a new 2D matrix with size m X n. Each box stores maximum number of ways we take to reach that particular amount with the coins we have
        int[][] dp = new int[m][n];
        // Fill in the first column with 1's as for [0][0], there is one chance by not giving anything
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        // Iterate through every coin and amount, If amount is less than coins[i], we could just copy the above dp array data else sum of i-1th index and same amount and value going coins[i-1] steps back 
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
            }
        }
    
        // return value
        return dp[m-1][n-1];
    }
}