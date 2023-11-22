//T.C O(m*n) -- if m(colors are limited) its O(n)
//S.C O(m*n)
// Did this code successfully run on Leetcode : No premium account
// Any problem you faced while coding this : -
/*
Sol: Use Dynamic Programming bottom up approach. For each cost of last house, calc min of costs for last but 1 and so on
Save results in a matrix, the first row then contains cumulative sum of all houses with min cost for each color. Choose min
of all cols in row 0.
 */
public class PaintHouse {
    int minCostDPMatrix(int[][] costs){
        //null check
        if(costs == null || costs.length == 0) return 0;

        //design DP matrix
        int m = costs.length; //houses
        int n = 3; //R B G colors
        int[][] dp = new int[m][3];

        //Fill DP matrix with last entry- cost of last house paints
        dp[m-1][0] = costs[m-1][0];
        dp[m-1][1] = costs[m-1][1];
        dp[m-1][2] = costs[m-1][2];

        for(int i = m-2; i>=0; i--)
        {
            dp[i][0] = Math.min(dp[i+1][1], dp[i+1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i+1][0], dp[i+1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i+1][0], dp[i+1][1]) + costs[i][2];
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String ar[]) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        int res =  new PaintHouse().minCostDPMatrix(costs);
        System.out.println("Min cost is::" + res);
    }

}
/*
Problem Statement: Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or green.
the cost for painting a particular house with a particular colour is going to be different.
you have to colour the house in such a way that no two adjacent houses will have the same colour.
the cost for painting  a house with any colour is represented by a n X 3 cost matrix where cost for painting house 0
with colour red is cost[0][0] and cost for painting house 4 with green colour is cost[4][2] and so on.....
calculate the minimum cost to paint all houses. try to optimize it for space !!
 */
