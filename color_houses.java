// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :

class PaintHouse{
    public int minCost(int[][] costs) {
        int n = costs.length-1;
        
        for(int i = costs.length -2; i>=0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1])
        }
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }