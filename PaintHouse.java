// TC - O (3n)
// SC - O (1)
class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;

        for(int i = n - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}

// TC - O (n)
// SC - O (n)
class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;

        int[] dp = new int[3];
        dp[0] = costs[n-1][0]; 
        dp[1] = costs[n-1][1]; 
        dp[2] = costs[n-1][2]; 

        for(int i = n - 2; i >= 0; i--) {
            int tmp1 = dp[0];
            dp[0] += costs[i][0] + Math.min(costs[1], costs[2]);
            int tmp1 = dp[1];
            dp[1] += costs[i][1] + Math.min(costs[0], costs[2]);
            dp[2] += costs[i][2] + Math.min(costs[0], costs[1]);
        }

        return Math.min(Math.min(costs[0], costs[1]), costs[2]);
    }
}

// TC - O (n)
// SC - O (1)
class PaintHouse {
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;

        int costR = costs[n-1][0]; 
        int costB = costs[n-1][1]; 
        int costG = costs[n-1][2]; 

        for(int i = n - 2; i >= 0; i--) {
            int tmpR = costR;
            costR += costs[i][0] + Math.min(costB, costG);
            int tmpB = costB;
            costB += costs[i][1] + Math.min(tmpR, costG);
            costG += costs[i][2] + Math.min(tmpR, tmpB);
        }

        return Math.min(Math.min(costR, costB), costG);
    }
}