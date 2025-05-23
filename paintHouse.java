// Time complexity: O(n)

// Space complexity: O(1)

// Approach : 
// we will use a dp array with 3 space
//  iterate over the coins array and choose which is the min values for each level by comparing the other 2
//  this way we get the least cost for every path thats possible.

public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;

    int n = costs.length;
    int[] dp = new int[3];

    // Initialize dp with the costs of the last house
    dp[0] = costs[n - 1][0];
    dp[1] = costs[n - 1][1];
    dp[2] = costs[n - 1][2];

    for (int i = n - 2; i >= 0; i--) {
        int red = costs[i][0] + Math.min(dp[1], dp[2]);
        int blue = costs[i][1] + Math.min(dp[0], dp[2]);
        int green = costs[i][2] + Math.min(dp[0], dp[1]);

        dp[0] = red;
        dp[1] = blue;
        dp[2] = green;
    }

    return Math.min(dp[0], Math.min(dp[1], dp[2]));
}
