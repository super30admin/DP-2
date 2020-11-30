/** You are given coins of different denominations and a total amount of money. 
* Write a function to compute the number of combinations that make up that amount. 
* You may assume that you have infinite number of each kind of coin.

* Time and space complexity O(NM)
*/
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null)
            return 0;
        int[][]dp = new int[coins.length+1][amount+1];
        int n = dp.length; //row
        int m = dp[0].length; //colums
        for (int i = 0; i<n; i++){
           dp[i][0] = 1;
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j < m; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}
