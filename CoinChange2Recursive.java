/*
 *Time an space complexity is exponential
 */
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return -1;

        return coinChangeHelper(coins, 0, amount);
    }

    public int coinChangeHelper(int coins[], int index, int amount){
        if(amount == 0) {
            return 1;
        }

        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        //do not use coin at index so amount won't change and index will increase as we are not considering this coin
        int case0 = coinChangeHelper(coins, index + 1, amount);

        //Case 1 is we are considering the coin so amount will be deducted from the coin used and index won't increment as we can use this coin again as we have infinite supply
        int case1 = coinChangeHelper(coins, index, amount - coins[index]);

        return case0 + case1;
    }

}
