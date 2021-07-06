// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution{
    public int minCost(int[][] costs){
        //base case to check if the array is empty
        if(costs == null || costs.length == 0){
            return 0;
        }

        //loop through all the houses
        for(int i = costs.length - 2; i >=0; i--){

            //we pick the minimum out of the other two options in each case
            costs[i][0] = Math.min(costs[i + 1][1], costs[i+1][2]);
            costs[i][1] = Math.min(costs[i + 1][0], costs[i+1][2]);
            costs[i][2] = Math.min(costs[i + 1][1], costs[i+1][0]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}