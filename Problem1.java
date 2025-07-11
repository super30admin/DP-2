//Time Complexity: O(m*n) where m is the number of coins and n is the amount
// Space Complexity: O(m*n) we are using a 2D dp array to store the number of ways to make each amount
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Three line explanation of solution in plain english:
// 1. We are using a 2D dp array to store the number of ways to make each amount
// 2. We iterate through the coins and for each coin, we update the dp array to reflect the number of ways to make each amount using that coin.
// 3. Finally, we return the number of ways to make the target amount by looking at the last cell of the dp array.

class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        // Fill the first column with 1 to indicate that there is one way to make amount 0 (by not using any coins)
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                // If the current amount is 0, there is one way to make it (by not using any coins)
                if(j<coins[i-1]){
                    // If the current amount is less than the coin value, we cannot use this coin
                    // So we take the value from the previous row (not using this coin)
                    dp[i][j]=dp[i-1][j];
                }

                // if the amount is greater than or equal to the coin value:
                // We take the sum of result of previous row (not using this coin(repeated subproblem)) and the value from the same row but with the amount reduced by the coin value
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        // The value in the last cell of the dp array represents the number of ways to make the amount using the given coins so far
        return dp[m][n];

    }
}