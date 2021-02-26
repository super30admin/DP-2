// Time Complexity - O(m)
// Space Complexity - O(3m) ~ O(m)

class Solution {
    public int minCost(int[][] costs) {
        
        // Check if costs length is 0, return 0
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        // Initializing m and n to costs array length and 3(as we have 3 columns in each row)
        int m = costs.length;
        int n = 3;
        // Initializing dp array with m X n size, each block stores the least it took to paint
        int[][] dp = new int[m][n];
        // Fill first column with costs[0] data.
        for(int i=0; i<n; i++){
            dp[0][i] = costs[0][i];
        }
        // Iterate from i=1 and j=0, If j is 0, dp array at ith and jth index would be costs[i][j] and minimum of previous row, 1st and 2nd column. Similarly if j == 1, we add the costs value and min of previous row 0th and 2nd column
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j == 0){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);    
                }else if(j == 1){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);    
                }else if(j == 2){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);    
                }
            }
        }
        // return min of last row values
        return Math.min(Math.min(dp[m-1][0], dp[m-1][1]), dp[m-1][2]);
    }
}