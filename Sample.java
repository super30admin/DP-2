

// Your code here along with comments explaining your approach
/** 
 * // Time Complexity : O(n*m)
 * // Space Complexity : O(n*m)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
public class coinChange2 {
    public static int change(int amount, int[] coins) {

        if(coins == null|| coins.length ==0){
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i< dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j< dp[0].length; j++){

                if( j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];

                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];

                }
            }
        }

        return dp[coins.length][amount];

    }
