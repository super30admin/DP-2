// Time Complexity : O(n) // fixed number of colours (3), and we iterate each house (n)
// Space Complexity : O(1) // using given 2d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class PaintHouseSolution {
    public int minCost(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        
        int first = Math.min(costs[0][0], costs[0][1]);
        return Math.min(first, costs[0][2]);
    }
}
