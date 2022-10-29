// Time Complexity : O(2^h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Problem2 {

    public static int[][] dp;

    public static int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return change(amount, coins, 0);
    }

    public static int change(int amount, int[] coins, int index) {
        // base
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index == coins.length) {
            return 0;
        }
        // recurse
        if (dp[index][amount] == -1) {
            int select = change(amount - coins[index], coins, index);
            int notSelect = change(amount, coins, index + 1);

            dp[index][amount] = select + notSelect;
        }
        return dp[index][amount];

    }
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(change(amount, coins));
    }
}
