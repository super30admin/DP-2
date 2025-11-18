// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        //coin change 1 we had to find min no of ways to make amt
        //Here we have to find total num of ways to make amt
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];

        //amount = 0 will always be reached in 1 way
        dp[0][0] = 1;

        //case 1:- dp[idx][amount] = dp[idx][amount - coins[idx]] (Choose coin)
        //case 2:- dp[idx][amount] = dp[idx - 1][amount] (Do not choose coin)

        //Traversing through coins
        for(int i = 1; i <= m; i++) {

            //Traversing through each amount
            for(int j = 0; j <= n; j++) {

                //if the coin is greater than amount then we avoid that coin
                if(coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }

        //last index
        return dp[m][n];
    }
}