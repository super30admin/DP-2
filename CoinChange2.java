//Time Complexity: O(n)
//Space Complexity: O(amount)
// Did this code successfully run on Leetcode : Yes

//Unlike the Coin Change problem where we were calculating the no of coins to make the total amount, we are calculating the no of ways we can make the total amount
//instead of storing min coins that make the total amount in the dp, we will store the no of ways we can make the total amount with a given denomination
public class CoinChange2 {

    /**
     *
     * @param amount the total amount of money
     * @param coins  the denominations
     * @return       the total combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        final CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(11, new int[] {1, 2, 5})); //return 11
        System.out.println(coinChange2.change(4, new int[] {1, 2, 5}));  //return 4
        System.out.println(coinChange2.change(3, new int[] {2, 5}));    //return 0
    }
}
