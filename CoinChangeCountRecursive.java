/**
 * Time complexity is exponential
 * space complexity is exponential because of recursive calls
 * 
 * does not work on leetcode
 */
class Solution {
    public int change(int amount, int[] coins) {
        int res = coinChange(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int coinChange(int[] coins, int amount, int i) {
        if(amount < 0 || i >= coins.length) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        // include coin[i]
        int case1 = coinChange(coins, amount-coins[i], i);
        
        //don't include coin[i]
        int case2 = coinChange(coins, amount, i+1);
        return case1 + case2;
    }
}