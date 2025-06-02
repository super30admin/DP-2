// Time Complexity : O( m x n)
// Space Complexity : O( m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach : wrote down tree for exhaustive solution and built
// dp matrix based off the logic used



public class coinChange2 {
        public static int change(int amount, int[] coins) {
            int m = coins.length;
            int n = amount;

            int[][] dp = new int[m + 1][n + 1];

            dp[0][0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    //till the amount reaches coin denomination
                    if (j < coins[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }

                }

            }
            return dp[m][n];
        }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;

        System.out.println(" Output is " + change( amount, coins));
    }
}
