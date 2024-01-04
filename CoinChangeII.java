/*
* Approach:
*  1. Here, we have to count all the ways of forming the given amount
* 
*  Therefore, we have to add choose case possibilities + 
                    non choose case possibilities to get total ways.
* 
*  2. Here, we are having 2 input variables, amount and index.
        Therefore, we are using 2-dimensional array.

   3. As, we are depending on current and previous rows, 
        we can use 1-dimensional array.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(amount*coins)
* 
* Space Complexity: O(amount)
* 
*/

public class CoinChangeII {
    // exhaustive
    // private int change(int amount, int[] coins, int index) {

    // if (index >= coins.length || amount < 0)
    // return 0;

    // if (amount == 0)
    // return 1;

    // return change(amount - coins[index], coins, index) +
    // change(amount, coins, index + 1);

    // }

    public int change(int amount, int[] coins) {
        // return change(amount, coins, 0);

        // tabulation
        // int[][] dp = new int[coins.length + 1][amount + 1];

        // dp[0][0] = 1;

        // for (int index = 1; index <= coins.length; index++) {
        // for (int amountVal = 0; amountVal <= amount; amountVal++) {
        // // choose
        // if (amountVal - coins[index - 1] >= 0)
        // dp[index][amountVal] += dp[index][amountVal - coins[index - 1]];

        // // not choose
        // dp[index][amountVal] += dp[index - 1][amountVal];
        // }
        // }

        // return dp[coins.length][amount];

        // space optimization

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int index = 1; index <= coins.length; index++) {
            for (int amountVal = 0; amountVal <= amount; amountVal++) {
                if (amountVal - coins[index - 1] >= 0)
                    dp[amountVal] = dp[amountVal - coins[index - 1]] + dp[amountVal];
            }
        }

        return dp[amount];
    }
}
