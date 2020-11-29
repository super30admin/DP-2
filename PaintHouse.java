package com.dp2;

public class PaintHouse {

    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        for (int i = 1 ; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min (costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min (costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min (costs[i-1][0], costs[i-1][1]);
        }

        return Math.min (costs[n-1][0],Math.min (costs[n-1][1],costs[n-1][2]));
    }

    public static void main(String[] args) {
        PaintHouse sol = new PaintHouse ();
        System.out.println (sol.minCost (new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
