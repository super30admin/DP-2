// Time Complexity :  o(n) n means no.of houses
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes 256
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        //we are starting from last row and finding values from its previoyus row
        for(int i=costs.length-2;i>=0;i--){
            //as for 0th column and starting from last but one row cause we need to make min using last row, at that index i,0 we should get min such that the houses cannot be adjacent so we get from min of i+1,1 and i+1,2 and adding current cost
            costs[i][0]+= Math.min(costs[i+1][1],costs[i+1][2]);
            //as for 1th column and starting from last but one row cause we need to make min using last row, at that index i,1 we should get min such that the houses cannot be adjacent so we get from min of i+1,0 and i+1,1  and adding current cost and we should not take i+1,1 as the adjacent houses should not be painted same 
            costs[i][1]+= Math.min(costs[i+1][0],costs[i+1][2]);
            //as for 2th column and starting from last but one row cause we need to make min using last row, at that index i,2 we should get min such that the houses cannot be adjacent so we get from min of i+1,0 and i+1,1 and adding current cost
            costs[i][2]+= Math.min(costs[i+1][1],costs[i+1][0]);
        }
        //return the max among these 3 values
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}