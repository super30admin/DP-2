class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int idx) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || idx == coins.length) {
            return 0;
        }

        int case1 = helper(coins, amount, idx + 1);
        int case2 = helper(coins, amount-coins[idx], idx);

        return case1+case2;
    }
}