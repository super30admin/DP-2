/*
Runtime complexity - O(N) - we are looping the cost array, N - number of house
Space complexity - O(1) - WE are only using three variable to store the cost of choosing each paint color for the previous house.

This code ran correctly in leetcode

*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;
        int cr=costs[costs.length-1][0];
        int cb=costs[costs.length-1][1];
        int cg=costs[costs.length-1][2];//Instead of re-using the input array, we are just making use of three variable as the number of colors to pain is three
        for(int i=costs.length-2;i>=0;i--)
        {
            int temp_r=cr;
            int temp_b=cb;
            int temp_g=cg;// Saving the values for each array in temp variable to do comparison later
            cr=costs[i][0]+Math.min(cb,cg);
            cb=costs[i][1]+Math.min(temp_r,cg);
            cg=costs[i][2]+Math.min(temp_r,temp_b);
        }
        return Math.min(cr,Math.min(cb,cg)); // Reached the first row, min of these three colors will give the result
    }
}
