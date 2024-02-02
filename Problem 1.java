//## Problem1(https://leetcode.com/problems/paint-house/)

// Time Complexity : DP-O(N), where N is the number of houses
// Space Complexity : DP-O(3*N) => O(N), where N is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    //1. Exhaustive recursive solution
    private int helper(int[][] costs, int idx, int color, int currCost){
        //base
        if(idx==costs.length)   return currCost;

        //logic
        // Previous house is painted red
        if(color==0){
            // Current house can be painted either green or blue
            int costG=helper(costs, idx+1, 1, currCost+costs[idx][color]);
            int costB=helper(costs, idx+1, 2, currCost+costs[idx][color]);
            // Return min cost
            return Math.min(costG, costB);
        }

        // Previous house is painted green
        if(color==1){
            // Current house can be painted either red or blue
            int costR=helper(costs, idx+1, 0, currCost+costs[idx][color]);
            int costB=helper(costs, idx+1, 2, currCost+costs[idx][color]);
            // Return min cost
            return Math.min(costR, costB);
        }

        // Previous house is painted blue
        if(color==2){
            // Current house can be painted either red or green
            int costR=helper(costs, idx+1, 0, currCost+costs[idx][color]);
            int costB=helper(costs, idx+1, 1, currCost+costs[idx][color]);
            // Return min cost
            return Math.min(costR, costB);
        }
        return 9999;
    }

    //2. DP solution of above exhaustive recursive code
    private int dp(int[][] costs){
        int m=costs.length;
        int n=costs[0].length;

        int[][] storage=new int[m][n];

        //Base case, last row, same as costs last row, as it is the only house that exists yet
        for(int color=0;color<n;color++)    storage[m-1][color]=costs[m-1][color];

        // Build table from bottom-up
        for(int house=m-2;house>=0;house--){
            // Current house red
            storage[house][0]=costs[house][0]+Math.min(storage[house+1][1], storage[house+1][2]);

            // Current house green
            storage[house][1]=costs[house][1]+Math.min(storage[house+1][0], storage[house+1][2]);

            // Current house blue
            storage[house][2]=costs[house][2]+Math.min(storage[house+1][0], storage[house+1][1]);
        }

        return Math.min(storage[0][0], Math.min(storage[0][1], storage[0][2])); 
    }


    public int minCost(int[][] costs) {
        //1. Exhaustive recursive solution
        // int firstHouseRed=helper(costs,0,0,0);
        // int firstHouseGreen=helper(costs,0,1,0);
        // int firstHouseBlue=helper(costs,0,2,0);
        // return Math.min(firstHouseRed, Math.min(firstHouseGreen, firstHouseBlue));

        //2. DP solution
        return dp(costs);
    }
}
