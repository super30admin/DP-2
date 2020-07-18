/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of coin.
 * 
 * Idea is to use dynamic programming, similar approach to previous problem coin
 * change.
 * 
 * Time Complexity: O(nm) n is the amount and m is the number of coins 
 * Space Complexity: O(n)
 * 
 * Leetcode Result:
 * 
 * Runtime: 2 ms, faster than 78.88% of Java online submissions for Coin Change
 * 2. Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for
 * Coin Change 2.
 */
class CoinChange2 {
    /**
     * compute the number of combinations that make up that amount.
     * 
     * @param coins  available denomination
     * @param amount target
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int amt = 1; amt <= amount; amt++) {
                if (amt >= coin) {
                    dp[amt] += dp[amt - coin];
                }
            }
        }
        return dp[amount];
    }
}
