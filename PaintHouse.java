// Recursive O(2^n) time, O(n) space
// class Solution {
//     // Red = 0, Blue = 1, Green = 2
//     public int minCost(int[][] costs) {
//         int red = helper(0, 0, costs);
//         int blue = helper(0, 1, costs);
//         int green = helper(0, 2, costs);

//         return Math.min(red, Math.min(blue, green));
//     }

//     public int helper(int i, int colorUsed, int[][] costs) {
//         if (i == costs.length) return 0;

//         int costHere = costs[i][colorUsed];

//         if (colorUsed == 0) { // red
//             int useBlue = helper(i+1, 1, costs);
//             int useGreen = helper(i+1, 2, costs);
//             return costHere + Math.min(useBlue, useGreen);
//         }
//         else if (colorUsed == 1) { // blue
//             int useRed = helper(i+1, 0, costs);
//             int useGreen = helper(i+1, 2, costs);
//             return costHere + Math.min(useRed, useGreen);
//         }
//         else { // green
//             int useRed = helper(i+1, 0, costs);
//             int useBlue = helper(i+1, 1, costs);
//             return costHere + Math.min(useRed, useBlue);
//         }
//     }
// }

// Bottom up DP O(n) time, O(n) space
class Solution {
    // Red = 0, Blue = 1, Green = 2
    public int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            int useRed = dp[i-1][0];
            int useBlue = dp[i-1][1];
            int useGreen = dp[i-1][2];
            
            dp[i][0] = costs[i][0] + Math.min(useBlue, useGreen);
            dp[i][1] = costs[i][1] + Math.min(useRed, useGreen);
            dp[i][2] = costs[i][2] + Math.min(useRed, useBlue);
        }
        int totalRedCost = dp[n-1][0];
        int totalBlueCost = dp[n-1][1];
        int totalGreenCost = dp[n-1][2];

        return Math.min(totalRedCost, Math.min(totalBlueCost, totalGreenCost));
    }
}