class MinCostPaintHouse {
    public int minCost(int[][] costs) {
        // int costR = helper(costs, 0, 0, 0);
        // int costB = helper(costs, 0, 0, 1);
        // int costG = helper(costs, 0, 0, 2);

        int m = costs.length; // num of houses
        int n = costs[0].length; // num of colours

        int[][] dp = new int[m][n];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < m; i++ ){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2]));

        // return Math.min(costR, Math.min(costB, costG));
    }

    private int helper(int[][] costs, int idx, int totalCost, int coloridx) {
        //base
        if(idx == costs.length) return totalCost;
        //chose
        if(coloridx == 0) {
            return Math.min(
                    helper(costs, idx+1, totalCost + costs[idx][1], 1),
                    helper(costs, idx+1, totalCost + costs[idx][2], 2)
            );
        }

        if(coloridx == 1) {
            return Math.min(
                    helper(costs, idx+1, totalCost + costs[idx][0], 0),
                    helper(costs, idx+1, totalCost + costs[idx][2], 2)
            );
        }

        if(coloridx == 2) {
            return Math.min(
                    helper(costs, idx+1, totalCost + costs[idx][0], 0),
                    helper(costs, idx+1, totalCost + costs[idx][1], 1)
            );
        }

        return 788;

    }
}

