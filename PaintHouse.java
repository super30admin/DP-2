//TC: O(N) SC: O(1)
class PaintHouse {
    public int minCost(int[][] costs) {
        //null
        if(costs == null || costs.length == 0) return 0;
        int[] dp = new int[costs[0].length];
        dp = costs[costs.length - 1];
        for(int i = costs.length-2; i >=0; i--) {
            int tempR = dp[0];
            int tempB = dp[1];
            int tempG = dp[2];
            dp[0] = Math.min(tempB,tempG) + costs[i][0];
            dp[1] = Math.min(tempR,tempG) + costs[i][1];
            dp[2] = Math.min(tempR,tempB) + costs[i][2];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
// public int minCost(int[][] costs) {
//         //null
//         if(costs == null || costs.length == 0) return 0;
//         int[][] dp = new int[costs.length][costs[0].length];
//         dp[costs.length - 1] = costs[costs.length - 1];
//         for(int i = costs.length-2; i >=0; i--) {
//             dp[i][0] = Math.min(dp[i+1][1],dp[i+1][2]) + costs[i][0];
//             dp[i][1] = Math.min(dp[i+1][0],dp[i+1][2]) + costs[i][1];
//             dp[i][2] = Math.min(dp[i+1][0],dp[i+1][1]) + costs[i][2];
//         }
//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//     }

//exponential - time limit exceeded
// public int minCost(int[][] costs) {
//         //null
//         if(costs == null || costs.length == 0) return 0;
//         int costR = helper(costs, 0 , 0 , 0);
//         int costB = helper(costs, 1 , 0 , 0);
//         int costG = helper(costs, 2 , 0 , 0);
//         return (Math.min(costR, Math.min(costB, costG)));
//     }

//     private int helper(int[][] costs, int color ,int i, int min) {
//         //base
//         if(i == costs.length) return min;
//         //logic
//         if(color == 0) {
//             return Math.min(helper(costs, 1, i+1, min+costs[i][0]), helper(costs, 2, i+1, min+costs[i][0]));
//         }
//         if(color == 1) {
//             return Math.min(helper(costs, 0, i+1, min+costs[i][1]), helper(costs, 2, i+1, min+costs[i][1]));
//         }
//         if(color == 2) {
//             return Math.min(helper(costs, 0, i+1, min+costs[i][2]), helper(costs, 1, i+1, min+costs[i][2]));
//         }
//         return -1;
//     }