public class PaintHouse {
    //time: O(n)
    
    public int minCost(int[][] costs) {
        int n = costs.length;
        // int[] dp = new int[3];
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        for (int i= n-2; i>=0; i--){
            int tempR = costR;
            costR = costs[i][0] + Math.min(costB,costG);
            int tempB = costB;
            costB = costs[i][1] + Math.min(tempR,costG);
            costG = costs[i][2] + Math.min(tempB, tempR);


        }
        return Math.min(costR, Math.min(costB,costG));
    }
    //time: O(n)
    // public int minCost(int[][] costs) {
    //     int n = costs.length;
    //     int[] dp = new int[3];
    //     dp[0] = costs[n-1][0];
    //     dp[1] = costs[n-1][1];
    //     dp[2] = costs[n-1][2];

    //     for (int i= n-2; i>=0; i--){
    //         int tempR = dp[0];
    //         dp[0] = costs[i][0] + Math.min(dp[1],dp[2]);
    //         int tempB = dp[1];
    //         dp[1] = costs[i][1] + Math.min(tempR,dp[2]);
    //         dp[2] = costs[i][2] + Math.min(tempR, tempB);


    //     }
    //     return Math.min(dp[0], Math.min(dp[1],dp[2]));
    // }

        //time: O(n)
    // public int minCost(int[][] costs) {
    //     int n = costs.length;
    //     int[][] dp = new int[n][3];
    //     dp[n-1][0] = costs[n-1][0];
    //     dp[n-1][1] = costs[n-1][1];
    //     dp[n-1][2] = costs[n-1][2];

    //     for (int i= n-2; i>=0; i--){
    //         dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
    //         dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
    //         dp[i][2] = costs[i][2] + Math.min(dp[i+1][1],dp[i+1][0]);


    //     }
    //     return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    // }

        //time: O(2^n)
    // public int minCost(int[][] costs) {
    //     int colorR = helper(costs, 0, 0);
    //     int colorB = helper(costs, 0, 1);
    //     int colorG = helper(costs, 0, 2);
    //     return Math.min(colorR, Math.min(colorB, colorG));
    // }
    // private int helper(int[][] costs, int idx, int col) {
    //     //baes
    //     if (idx == costs.length) return 0;
    //     //logic
    //     if(col==0){
    //         return costs[idx][0]+ Math.min(helper(costs,idx+1,1), helper(costs,idx+1,2));
    //     }
    //     if(col==1){
    //         return costs[idx][1]+ Math.min(helper(costs,idx+1,0), helper(costs,idx+1,2));
    //     }
    //     if(col==2){
    //         return costs[idx][2]+ Math.min(helper(costs,idx+1,0), helper(costs,idx+1,1));
    //     }
    //     return -1;
    // }
}
