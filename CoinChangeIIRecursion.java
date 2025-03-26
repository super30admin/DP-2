public class CoinChangeIIRecursion {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    private int helper(int amount, int[] coins, int i) {
        int n = coins.length;
        // base
        if (amount < 0 || i >= n)
            return 0;

        if (amount == 0) {
            return 1;
        }

        // Don't choose
        int case0 = helper(amount, coins, i + 1);

        // Choose
        int case1 = helper(amount - coins[i], coins, i);

        return case0 + case1;
    }
}

/**
 * TC: O(2^m+n)
 * SC: O(m+n)
 */
