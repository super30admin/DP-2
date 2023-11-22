//T.C O(m*n) -- if m(colors are limited) its O(n)
//S.C O(1)
// Did this code successfully run on Leetcode : No premium account
// Any problem you faced while coding this : -

//Space optimization can be done with 1D Array - instead of DP matrix
public class PaintHouse_SpaceOptimization {
    int minCostDPMatrix(int[][] costs){
        //null check
        if(costs == null || costs.length == 0) return 0;

        //design DP matrix
        int m = costs.length; //houses
        int[] dp = new int[3];

        //Initialize the array with the paint costs of the last house
        dp[0] = costs[m-1][0];
        dp[1] = costs[m-1][1];
        dp[2] = costs[m-1][2];

        for(int i = m-2; i>=0; i--)
        {
            //Need temp variables to store old dp[] values as we are changing them here in each step
            int tempR = dp[0], tempB = dp[1];
            dp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            dp[1] = Math.min(tempR, dp[2]) + costs[i][1];
            dp[2] = Math.min(tempR, tempB) + costs[i][2];
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String ar[]) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        int res =  new PaintHouse().minCostDPMatrix(costs);
        System.out.println("Min cost is::" + res);
    }
}
