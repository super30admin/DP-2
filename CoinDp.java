// Number of ways we can achieve the amount using coins

// Time Complexity : log(coin.length+1 * amount+1)
// Space Complexity : log(coin.length+1 * amount+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class CoinDp {

    public int change(int amount, int[] coins) {

        if (coins == null)
            return 0;

        int[][] memo = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 1;
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {

                if (j < coins[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else
                    memo[i][j] = memo[i - 1][j] + memo[i][j - coins[i - 1]];
            }
        }
        return memo[coins.length][amount];
    }

    public static void main(String[] args) {

    }
}
