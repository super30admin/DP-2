// Time Complexity :exponential
// Space Complexity :exponential
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :No (coded after class)

class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    public int helper(int amount, int[] coins, int index) {
        // base case
        if (amount == 0)// if we reached amount we found a way
            return 1;
        if (index >= coins.length || amount < 0)// if amount becomes negative and index goes out of bound, means we have
                                                // no way
            return 0;
        // logic
        // if we choose
        int case1 = helper(amount - coins[index], coins, index);
        int case2 = helper(amount, coins, index + 1);
        return case1 + case2;// add both as we have to return all possible cases
    }
}

// -------------------OPTIMIZED------------------
// Time Complexity :O(n*m) where m is length of coins array+1 and n i amount+1
// Space Complexity :O(n*m) where m is length of coins array+1 and n i amount+1
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];// make a 2d array
        dp[0][0] = 1;
        // in 2d array
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {// until amount is less than coin denomination,take previous no.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];// else add previous no and steps back to get
                                                                      // totak no of ways
                }
            }
        }
        return dp[coins.length][amount];
    }
}

// --------------USING 1D ARRAY----------------
// Time Complexity :O(m*n) where m is length of coins and n is amount
// Space Complexity :O(n) where n is amount
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// overwriting array as we are not using previous row again and returning last
// index
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (coins[i - 1] <= j) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];

                }

            }
        }
        return dp[amount];
    }
}