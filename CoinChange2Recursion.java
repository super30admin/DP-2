// TC: O(2^9)
class Solution {
    public int helper(int[] coins, int amount, int ind) {
        //valid path
        if(amount == 0) {
            return 1;
        }
        //invalid path
        if(amount < 0 || ind == coins.length) {
            return 0;
        }
        int case1 = helper(coins, amount - coins[ind], ind);
        int case2 = helper(coins, amount, ind + 1);
        // will be returning sum of all valid paths
        return case1 + case2;
    }
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        return helper(coins, amount, 0);
    }
}