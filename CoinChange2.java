// Time Complexity : O(n) [n = target]
// Space Complexity : O(1) [since using 1-D array]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Kind off, had to see the video multiple time


// Your code here along with comments explaining your approach



class Solution {
    public int change(int amount, int[] coins) {
        // return helperRecursion(coins, 0, amount);

        // int m = coins.length + 1;
        // int n = amount + 1;
        // int dp[][] = new int[m][n];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return helperMemoization(coins, 0, amount, dp);

        // return helperTabulation(coins, amount);

        return helperOptimizedTabulation(coins, amount);

    }

    // public int helperRecursion(int[] coins, int idx, int target) {
    // int count = 0;

    // // Base
    // if (target == 0) {
    // return (++count);
    // }

    // // logic
    // if (target < 0 || idx == coins.length) {
    // return count;
    // }

    // // choose
    // count += helperRecursion(coins, idx, target - coins[idx]);

    // // Not choose
    // count += helperRecursion(coins, idx + 1, target);

    // return count;
    // }

    // public int helperMemoization(int[] coins, int idx, int target, int dp[][]) {

    //     // Base case
    //     if (target == 0) {
    //         return 1; // One way to make change (by not choosing any coin)
    //     }

    //     // Check if the target is negative or all coins are used
    //     if (target < 0 || idx == coins.length) {
    //         return 0; // No way to make change
    //     }

    //     // Check if the result for the current target is already memoized
    //     if (dp[idx][target] != -1) {
    //         return dp[idx][target];
    //     }

    //     // Choose the current coin and move to the next iteration
    //     int choose = helperMemoization(coins, idx, target - coins[idx], dp);

    //     // Not choose the current coin and move to the next iteration
    //     int notChoose = helperMemoization(coins, idx + 1, target, dp);

    //     // Update the memoization table with the sum of both choices
    //     dp[idx][target] = choose + notChoose;
    //     return dp[idx][target];
    // }

    // private int helperTabulation(int[] coins, int target) {
    //     int m = coins.length;
    //     int n = target;
    //     int dp[][] = new int[m + 1][n + 1];
    //     dp[0][0] = 1;

    //      System.out.println("m: " + m + " n: " + n);
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 0; j <= n; j++) {
    //             if (j < coins[i - 1]) {
    //                 dp[i][j] = dp[i - 1][j]; // just above value in the m X n matrix --- no choose case
    //             } else {
    //                 dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // choose case --- above value + same row previous nth value idx
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }

    private int helperOptimizedTabulation(int[] coins, int target) {
        int m = coins.length;
        int n = target;
        int dp [] = new int [n + 1]; 

        dp[0] = 1; 

        for(int i = 1; i <= m; i++) {
            for (int j = 0; j<= n; j++) {
                if(j < coins[i -1]) {
                    dp[j] = dp[j];   // same value at [j] --- no choose case
                } else {
                    dp[j] = dp[j] + dp[j - coins[i-1]]; // choose case --- aame value at [j] + same row previous nth value idx
                }
            }
        }

        return dp[n];
    }
}