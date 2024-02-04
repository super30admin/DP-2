// Time Complexity : O(n) [n = length of costs array]
// Space Complexity : Not using extra spce
// Did this code successfully run on Leetcode : NA, premium problem
// Any problem you faced while coding this : Yes, getting confused with recursive approach


// Your code here along with comments explaining your approach

public class PaintHouse {

    // public static int exhaustiveSolution(int[][] costs) {

    //     int m = costs.length;
    //     int n = 3;

    //     int dp[][] = new int[m][n];

    //     for (int i = m - 1; i >= 0; i--) {

    //         for (int j = n - 1; j >= 0; j--) {
    //             if (i == m - 1) {
    //                 dp[i][j] = costs[i][j];
    //             } else {
    //                 if (j == 2) {
    //                     dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j - 2]);
    //                 } else if (j == 1) {
    //                     dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]);
    //                 } else {
    //                     dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j + 1], dp[i + 1][j + 2]);
    //                 }
    //             }
    //         }
    //     }
    //     return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    // }

    public static int iterativeOptimizedSolution(int[][] costs) {

        int m = costs.length;

        for (int i = m - 2; i >= 0; i--) {

            costs[i][2] = costs[i][2] + Math.min(costs[i + 1][1], costs[i + 1][0]);

            costs[i][1] = costs[i][1] + Math.min(costs[i + 1][2], costs[i + 1][0]);

            costs[i][0] = costs[i][0] + Math.min(costs[i + 1][2], costs[i + 1][1]);

        }
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }

    // private static int helperRecursive(int[][] costs, int idx, int color, int costTillNow) {
    //     // base
    //     if (idx == costs.length) {
    //         return costTillNow;
    //     }

    //     // logic
    //     if (color == 0) {
    //         return Math.min(
    //                 helperRecursive(costs, idx + 1, 1, costTillNow + costs[idx][0]),
    //                 helperRecursive(costs, idx + 1, 2, costTillNow + costs[idx][0]));
    //     }

    //     if (color == 1) {
    //         return Math.min(
    //                 helperRecursive(costs, idx + 1, 0, costTillNow + costs[idx][1]),
    //                 helperRecursive(costs, idx + 1, 2, costTillNow + costs[idx][1]));
    //     }

    //     if (color == 2) {
    //         return Math.min(
    //                 helperRecursive(costs, idx + 1, 0, costTillNow + costs[idx][2]),
    //                 helperRecursive(costs, idx + 1, 1, costTillNow + costs[idx][2]));
    //     }

    //     return 1234344333;

    // }

    public static void main(String args[]) {

        // int[][] costs = new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        // System.out.println(iterativeOptimizedSolution(costs));

        int[][] costs1 = new int[][] { { 7, 6, 2 } };
        System.out.println(iterativeOptimizedSolution(costs1));

        // int[][] costsR = new int[][] { { 17, 2, 18 }, { 16, 5, 14 }, { 14, 3, 19 }, { 15, 20, 8 } };
        // int costR = helperRecursive(costsR, 0, 0, 0);
        // int costB = helperRecursive(costsR, 0, 1, 0);
        // int costG = helperRecursive(costsR, 0, 2, 0);
        // System.out.println(Math.min(Math.min(costR, costB), costG));

    }
}
