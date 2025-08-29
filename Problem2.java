// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes while checking for null condition


// Your code here along with comments explaining your approach
/*
Uses Memoization approach which is topdown to solve the overlapping subproblems
Maintain a 2D array to store the coins and amount
Check if subarray repeats if yes store in 2D array
consider 2 cases where one is to skip the current coin(case0) other takes current 1(case1)
*/
class Solution {
    Integer[][] memo;
    public int change(int amount, int[] coins) {
        this.memo = new Integer[coins.length][amount+1];
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amt, int idx) {
        //base
        if(amt == 0) return 1; //there exists atleast one combination
        if (idx == coins.length || amt < 0) return 0; //invalid path
        if (memo[idx][amt] != null) {
            return memo[idx][amt]; //this subarray is already been calculated
        }
        //logic
        //SKIP ie 0th case
        int case0 = helper(coins, amt, idx+1);
        //TAKE ie 1th case
        int case1 = helper(coins, amt - coins[idx], idx);
        int res = case0 + case1;
        memo[idx][amt] = res;
        return res;
    }
}
