// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j];
            }
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < 3; j++) {
                int temp = Integer.MAX_VALUE;
                int k = 0;
                while( k < 3) {
                    if( j != k) {
                        temp = Math.min(temp, dp[i+1][k]);
                    }
                    k++;
                }
                dp[i][j] = dp[i][j] + temp;
            }
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}