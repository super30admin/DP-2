// Time Complexity : O(mn) where m is the amount and n is the number of coins
// Space Complexity : O(mn) matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Pattern finding
/* Your code here along with comments explaining your approach: We do tabulation by number of coins as the rows and amount as columns.
The first column is filled with 1's because of calculation sake. If the coin is greater than the amount, then the value at the current cell
will be the same value in the above row else the value will be the value from previous row plus the value that is dp[j-coins[i]] steps back becuase
these are the number of ways that this coin can get j amount.
*/
class Solution {
    public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length+1][amount+1]; 
    for(int i = 0; i < dp.length;i++){
        dp[i][0] = 1;
    }
    for(int i = 1; i < dp.length; i++){
        for(int j =1; j < dp[0].length; j++){
            if(j < coins[i-1]){
            dp[i][j]=dp[i-1][j];                    // if amount > coins value
            } else {
                dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];         //number of ways coins[i] can make the amount j
            }
        }
    }
            return dp[dp.length-1][dp[0].length-1];                 // the last value gives the final answer
    }
}