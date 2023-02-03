/*
approach: dynamic programming

time: O(m*n)
space: O(m*n)
 */
public class Problem2 {
    static int change(int amount, int[] coins) {
        int r = coins.length;
        int c = amount;

        int[][] dp = new int[r+1][c+1];

        dp[0][0] = 1;

        for (int i=1;i<dp.length;i++){
            for (int j=0; j<dp[0].length;j++){

                if (j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[r][c];
    }
    public static void main(String[] args) {
        System.out.println("min cost for painting "+change(11, new int[]{1,2,5}));
    }
}
