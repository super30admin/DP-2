//Time complexity: O(N)
//Space complexity: O(N), because space is occupied by recursion stack
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        return helperMethod(coins, amount, 0);
    }

    private int helperMethod(int[] coins, int amount, int index) {
        //base case
        //If the amount becomes 0 we will return the minimum coins used.
        if(amount == 0) {
            return 1;
        }
        if(amount < 0 || index == coins.length) {
            return 0;
        }
        //choose
        //for case1, if we choose the coins at current index, amount will be = amount - coin at current index
        //we can choose the same coin again so index can be same
        int case1 = helperMethod(coins, amount - coins[index], index);
        //not choose
        //if we dont choose current coin, the amount will be same, we will move to the next coin.
        int case2 = helperMethod(coins, amount, index + 1);
        return case1 + case2;
    }
}