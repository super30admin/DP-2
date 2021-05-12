/*

Thought Process: Identify this problem as a DP problem. Used top-down approach to find the add min from second level from above level two other clor values. Return the min sum from the last level.

T.C - O(N) Length / Number of rows of the costs array
S.C - O(1) Storing the values in the costs array itself.

*/

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}