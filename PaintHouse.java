// Time Complexity : O(n) where n is #houses * color
// Space Complexity : O(h) where h is #houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int minCost(int[][] costs) {

    int n = costs.length;

    int[] dp = costs[0];

    for (int i = 0; i < n; i++) {

        int[] curr = new int[3];

        // Red
        curr[0] = costs[i][0] + Math.min(dp[1], dp[2]);

        // Green
        curr[1] = costs[i][1] = Math.min(dp[0], dp[2]);

        // Blue
        curr[2] = costs[i][2] = Math.min(dp[0], dp[1]);

        dp = curr;
    }

    return Math.min(
            dp[0],
            Math.min(
                    dp[1], dp[2]
            )
    );

}

// // Recursive TLE solution

// class Solution {

//     // R = 0, G = 1, B = 2

//     public int minCost(int[][] costs) {
//         int h0Red = costs[0][0] + minCost(costs, 1, 0);
//         int h0Green = costs[0][1] + minCost(costs, 1, 1);
//         int h0Blue = costs[0][2] + minCost(costs, 1, 2);

//         return Math.min(
//             h0Red, 
//             Math.min(
//                 h0Green, 
//                 h0Blue)
//             );
//     }

//     private int minCost(int[][] costs, int index, int prevColor) {
//         // base
//         if (index == costs.length) {
//             return 0;
//         }
//         // recurse
//         if (prevColor == 0) { // Red = 0
//             return Math.min(
//                 costs[index][1] + minCost(costs, index+1, 1), // Green
//                 costs[index][2] + minCost(costs, index+1, 2) // Blue
//                 );
//         }
//         if (prevColor == 1) {
//             return Math.min(
//                 costs[index][0] + minCost(costs, index+1, 0), // Red
//                 costs[index][2] + minCost(costs, index+1, 2) // Blue
//                 );
//         }
//         if (prevColor == 2) {
//             return Math.min(
//                 costs[index][0] + minCost(costs, index+1, 0), // Red 
//                 costs[index][1] + minCost(costs, index+1, 1) // Green
//                 );
//         }
//         return -1;
//     }
// }
