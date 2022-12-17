// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*
 * 1 - This problem we do case 1 + case in recursion - same to be done in the DP table
 * 2 - Solve it by recursion - observe TLE, build the recursion table, 
 * 3 - zero case is coming from right above and one case comes from left hand side depending on the
 * coin denomination. If 2, go two steps back. IF 5, go five steps back.
 * 4 - Add both zero case and one case together
 */

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m + 1][n + 1];
        
        dp[0][0] = 1;
        for(int i = 1; i < dp.length;i++)
        {
            for(int j = 0; j <dp[0].length ;j++)
            {
                if(j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][n];
    }
}
