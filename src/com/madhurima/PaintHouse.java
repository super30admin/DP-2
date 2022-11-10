/*
Time Complexity = O(n)
Space Complexity = O(1) if we update the same coins array OR O(n) if we create a new dp array
Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class PaintHouse {
}

class SolutionB1 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }

        int n = costs.length;
        int[][] dp = new int[n][3];

        //fill last row in new dp array
        for(int i = 0; i < 3; i++){
            dp[n-1][i] = costs[n-1][i];
        }


        //if updating same costs array (which would make space complexity constant)
        // for(int i = n - 2; i >= 0; i--){
        //     costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
        //     costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
        //     costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        // }

        //if we update new array, add space complexity of O(n*3)
        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }



        int min = Integer.MAX_VALUE;

        //if updating same costs array
        // for(int i = 0; i < 3; i++){
        //     min = Math.min(min, costs[0][i]);
        // }

        //if updating new dp array
        for(int i = 0; i < 3; i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;


        //recursive solution which leads to time limit exceeded
//         //R = 0, B = 1. G = 2
//         int case1 = helper(costs, 0, 0, 0);
//         int case2 = helper(costs, 0, 1, 0);
//         int case3 = helper(costs, 0, 2, 0);

//         return Math.min(case1, Math.min(case2, case3));


    }


    //recursive solution - which exceeds time limit
    private int helper(int[][] costs, int index, int color, int totalCost){
        //base
        if(index == costs.length){
            return totalCost;
        }

        if(color == 0){
            return Math.min(helper(costs, index+1, 1, totalCost + costs[index][0]),
                    helper(costs, index+1, 2, totalCost + costs[index][0]));
        }else if(color == 1){
            return Math.min(helper(costs, index+1, 0, totalCost + costs[index][1]),
                    helper(costs, index+1, 2, totalCost + costs[index][1]));
        }else{
            return Math.min(helper(costs, index+1, 0, totalCost + costs[index][2]),
                    helper(costs, index+1, 1, totalCost + costs[index][2]));
        }

    }
}
