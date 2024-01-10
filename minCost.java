class Solution {
    public int minCost(int[][] costs) {
        //Tc: O(n) Sc: O(n)
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i = n-2; i >= 0 ; i--)
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));

        /*
        //Tc: O(n)  Sc: O(1)
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;

        for(int i = n-2; i>= 0 ; i--)
        {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
*/
        //Exhaustive Approach
        /*
        if(costs == null || costs.length == 0) return 0;
        int caseR = helper(costs, 0, 0, 0);
        int caseB = helper(costs, 0, 1, 0);
        int caseG = helper(costs, 0, 2, 0);
        return Math.min(caseR, Math.min(caseG, caseB));
        
    }

    private int helper(int[][] costs, int r, int color, int minCost)
    {
        if(r == costs.length) return minCost;

        if(color == 0)
        {
            return 
            Math.min(helper(costs, r+1, 1, minCost + costs[r][0]),
            helper(costs, r+1, 2, minCost + costs[r][0] ));
        }
        if(color == 1)
        {
            return
            Math.min(helper(costs, r+1, 0, minCost + costs[r][1]),
            helper(costs, r+1, 2, minCost + costs[r][1] ));

        }
        if(color == 2)
        {
            return 
            Math.min(helper(costs, r+1, 0, minCost + costs[r][2]),
            helper(costs, r+1, 1, minCost + costs[r][2]));

        }
        return -1;
        */
    }
}