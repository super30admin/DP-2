// COIN CHANGE II

// Time Complexity : O(mn), where m is the number of rows and n is the number of columns in the dp matrix
// Space Complexity : O(mn), where m is the number of rows and n is the number of columns in the dp matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) // Cannot proceed if the array itself is not initialized or if the there are no elements in the coins array
            return 0;
        int rows = coins.length; // Each of the rows will represent one denomination
        int cols = amount; // Columns will have all the possible numbers till amount
        int[][] dp = new int[rows + 1][cols + 1]; // Initialize dp 'matrix' because there are 2 decision making variables, coins and the amount. We will also be using a '0' dummy row and column to make sure the values for the first actual row are not manually calculated
        dp[0][0] = 1; // When the amount is 0, we return '1' way even in the recursive solution
        for(int i = 1; i <= rows; i++)
            dp[i][0] = 1; // When the amount is 0, we return '1' way even in the recursive solution, value for the dummy row
        for(int i = 1; i <= rows; i++){ // Loop through every cell in the dp matrix excluding the dummy row and column
            for(int j = 1; j <= cols; j++){
                if(j < coins[i - 1]) // We only have the zero case (amount above) of not choosing the coin until the amount becomes equal to the denomination because if we choose the coin, we will end up with a negative number
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]]; // Sum the number of ways found when coin is chosen and when it is not
            }
        }
        return dp[rows][cols]; // Total number of ways
    }
}