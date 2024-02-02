//space complexity, time complexity - O(n)
//Initialize a 2D array dp to store the minimum cost for each house-color combination.
//Iterate through each house, updating the minimum cost for each color based on the minimum cost of the previous house's other two colors.
//Return the minimum cost among the last row of the dp array.

class Solution{
    public int minCost(int[][] cost){
        int n = cost.length;
        int [][] dp = new dp[n][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for(int i=1;i<n;i++){
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}