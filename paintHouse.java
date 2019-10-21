//256. Paint House
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;

        int[][] dp = new int[costs.length][costs[0].length];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1; i<dp.length; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int n = dp.length;
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}


//256. Paint House
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;

        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];

        for(int i=1; i<costs.length; i++){
            int temp_r = costs[i][0] + Math.min(b, g);
            int temp_b = costs[i][1] + Math.min(r, g);
            int temp_g = costs[i][2] + Math.min(r, b);
            r = temp_r; b = temp_b; g = temp_g;
        }
        return Math.min(r, Math.min(b, g));
    }
}