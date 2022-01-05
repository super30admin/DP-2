//TC: O(m+n)
//SC: O(m*n)
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int row = 1; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (col < coins[row - 1]) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1]];
                }
            }
        }
        int result = dp[coins.length][amount];
        return result;
    }
}
//  0 1 2 3 4 5 6 7 8 9 10 11
//0 1 0 0 0 0 0 0 0 0 0 0 0
//1 1 1 1 1 1 1 1 1 1 1 1 1
//2 1 1 2 2 3 3 4 4 5 5 6 6
//5 1 1 2 2 3 4 5 6 7 8 10 11