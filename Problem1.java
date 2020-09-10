Time Complexity: O(mn). Size of Costs matrix.
Space Complecity: O(mn). DP array.
Ran successfully on leetcode?: yes

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = costs[i - 1][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
