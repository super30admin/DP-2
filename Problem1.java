class Problem1 {

    // Idea used here is to start from the second last row and choice the best option for each color.
    // then keep repeating this from row n-2 to 0
    // in the last iteration you would have best possible cost for each color

    // Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    public int minCost(int[][] costs) {

        int[][] dp = new int[costs.length][costs[0].length];
        int red = costs[costs.length - 1][0];
        int green = costs[costs.length - 1][1];
        int blue = costs[costs.length - 1][2];
        for (int i = costs.length - 2; i >= 0; i--) {
            int tempR = red;
            int tempG = green;
            int tempB = blue;
            red = costs[i][0] + Math.min(green, blue);
            green = costs[i][1] + Math.min(tempR, tempB);
            blue = costs[i][2] + Math.min(tempR, tempG);
        }

        return Math.min(red, Math.min(green, blue));
    }

    // For the below code:
    // Time Complexity : O(m)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//     public int minCost(int[][] costs) {

//         int[][] dp = new int[costs.length][costs[0].length];
//         dp[costs.length - 1][0] = costs[costs.length - 1][0];
//         dp[costs.length - 1][1] = costs[costs.length - 1][1];
//         dp[costs.length - 1][2] = costs[costs.length - 1][2];
//         for (int i = costs.length - 2; i >= 0; i--) {
//             dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
//         }

//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//     }


//     public int minCost(int[][] costs) {
//     // null check
//         if(costs == null) {
//             return -1;
//         }

//     // helper call
//         int caseR = helper(costs, 0, 0, 0);
//         int caseG = helper(costs, 0, 1, 0);
//         int caseB = helper(costs, 0, 2, 0);

//         return Math.min(caseR, Math.min(caseG, caseB));
//     }

//     private int helper(int[][] costs, int i, int j, int minCost) {
//         // base
//         if (i == costs.length) {
//             return minCost;
//         }
//         //logic
//         //choose
//         if (j == 0) {
//            return Math.min(helper(costs, i + 1, 1, minCost + costs[i][0]),
//                            helper(costs, i + 1, 2, minCost + costs[i][0]));
//         }

//         if (j == 1) {
//             return Math.min(helper(costs, i + 1, 0, minCost + costs[i][1]), 
//                             helper(costs, i + 1, 2, minCost + costs[i][1]));
//         }

//         if (j == 2) {
//             return Math.min(helper(costs, i + 1, 1, minCost + costs[i][2]), 
//                             helper(costs, i + 1, 0, minCost + costs[i][2]));
//         }

//         return -1;
//     }
}