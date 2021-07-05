518.COIN CHANGE 2
        You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

        Return the number of combinations that make up that amount.If that amount of money cannot be made up by any combination of the coins,return 0.

        You may assume that you have an infinite number of each kind of coin.

        The answer is guaranteed to fit into a signed 32-bit integer.

        Example 1:
        Input:amount=5,coins=[1,2,5]
        Output:4
        Explanation:there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1

        Example 2:
        Input:amount=3,coins=[2]
        Output:0
        Explanation:the amount of 3cannot be made up just with coins of 2.

// Time Complexity : O(MN) M coins and N amount
// Space Complexity : O(N) amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* For each added coin, compute recursively the number of combinations dp[i] = dp[i] + dp[i - coin] for each amount of money from 0 to amount.
return dp[amount]
 */

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}