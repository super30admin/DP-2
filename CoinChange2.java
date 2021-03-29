/**Leetcode Question - 518 */
/**Algorithm - DP is used
 * Create a 2D array to store the number of ways in which a given amount can be achieved
 * Number of ways of making the amount = No. of ways in the previous row + ((amount - coins value)- check for this value in the table.)
 * The last number in the matrix is the answer
 */
/** TC - O(MN) - M - number of rows, N - number pf columns
 * SC - O(MN)
 */
public class CoinChange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            if(coins == null){
                return 0;
            }
            int[][] dp = new int[coins.length+1][amount+1];
            for(int i =0; i<dp.length; i++){
                dp[i][0] = 1;
            }
            for(int i =1; i<dp.length; i++){
                for(int j = 1; j<dp[0].length; j++){
                    if(j <coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j- coins[i -1]];
                    }
                }
            }
            return dp[dp.length -1][dp[0].length-1];
        }
}
