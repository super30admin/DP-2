package DynamicProgramming;

/*
    Time complexity : o(m*n)
    space complexity: o(m*n)
    Did this code run successfully in leetcode : yes
    problems faces : no
    at every step either choose the element or not,
    if you have chosen an element  from the coin, reduce the total amount by coins[index] and increase the number of coins by one
    if you are not choosing the element at index, increase the index by one and keep the amount and number of coins as same
*/
public class CoinChange2WithDP {

    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {

            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    // zero case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}
