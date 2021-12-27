class Solution{
    public int minCost(int[][] costs){
        if(costs == 0 || costs.length == 0) return 0; // if there are no costs, we simply return 0;
        int n = costs.length; // we store the length of the costs in a variable n.
        int[][] dp = new int[n][3]; // we take a 2d array with n as the no. of rows and 3 as the no. of colomns(since there are 3 colors)
        for(int i = 0; i < 3; i++){ // we go through the array.
            dp[n-1][i] = costs[n-1][i]; // we take the costs of each location and store it in the 2d dp array.
        }
        for(int i = n-2; i >= 0; i++){ // we start from the second last row and keep decrementing
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);//the cost of the current path will be the cost of the path + the min between the other two costs of colors present in the row ahead of the current row. we need to perform the same actions for all the colors present in that particular row.
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2])); // in the end, we return the min of all the three.
    }
}
// tc - O(n) and sc - O(1)