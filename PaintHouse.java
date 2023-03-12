public class PaintHouse {
    // Time Complexity : O(mn) n is no of houses, m no of colors(3) which is constant , TC = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Require premium to see the problem on leetcode
// Any problem you faced while coding this : No

    public int minCost(int[][] costs) {
        int n = costs.length;
        if(costs == null) return 0;
        for(int i=n-2;i>=0;i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
