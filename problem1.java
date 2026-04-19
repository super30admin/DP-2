    /**
    Time Complexity : O(N)
    Explanation:
    We process each house once and compute cost for 3 colors.

    Space Complexity : O(N)
    Explanation:
    DP table of size N x 3 is used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried brute force recursion which was exponential.
    Then realized overlapping subproblems and converted it to DP.
    Also needed to ensure that adjacent houses don’t have same color,
    so for each color we pick minimum of the other two from next house.
    */


    class Solution {


        public int minCost(int[][] costs) {
    
            int n = costs.length;
    
            int[][] dp = new int[n][3];
    
            // Base case: last house
            dp[n - 1][0] = costs[n - 1][0];
            dp[n - 1][1] = costs[n - 1][1];
            dp[n - 1][2] = costs[n - 1][2];
    
            // Fill DP from bottom to top
            for (int i = n - 2; i >= 0; i--) {
    
                dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
            }
    
            // Final answer
            return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        }
    }