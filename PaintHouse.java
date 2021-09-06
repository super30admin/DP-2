// Time Complexity : O(N) ; we have n houses and 3 colors, O(n) for 3*(n-1) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class PaintHouse {
    public int minCost(int[][] costs) {
        for(int i=costs.length-2; i>=0;i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][1], costs[i+1][0]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}