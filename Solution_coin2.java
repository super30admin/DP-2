/*
// Time Complexity : O(n * m) where n is number of row in dp array and m is the number of the column in the dp array.
// Space Complexity : O(n *m) where n is number of row in dp array and m is the number of the column in the dp array.
// Did this code successfully run on Leetcode : Yes Worked.
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

*/
public class Solution_coin2 {

    public int change(int amount, int[] coins) {

        // checking null cases
        if (coins.length == 0 || coins == null)
            return 0;

        int dp[][] = new int[coins.length + 1][amount + 1];
        // adding the base case.
        for (int i = 0; i < dp.length; i++) {

            dp[i][0] = 1;
        }
        // traversig the dp array by row
        for (int i = 1; i < dp.length; i++) {

            // traversig the dp array by column

            for (int j = 1; j < dp[0].length; j++) {

                // choose case
                if (j >= coins[i - 1]) {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                // not choose case
                else {
                    // adding the just above element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
