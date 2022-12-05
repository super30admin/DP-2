// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int MinCost(int[][] costs) {
        if(costs.Length == 0 || costs == null)
            return 0;
        int m = costs.Length;
        
        for(int i = m-2 ; i >=0; i--)
        {
            costs[i][0] = costs[i][0] + Math.Min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.Min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.Min(costs[i+1][1], costs[i+1][0]);
        }
        return Math.Min(costs[0][0], Math.Min(costs[0][1], costs[0][2]));
    }
}
