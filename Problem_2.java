/*
Time Complexity : O(mn)
Space Complexity : O(n)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Implemented as explained in class.
*/

class coinChangeWays{
    static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i ++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args){
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.print(change(amount, coins));
    }
}

