// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        for (int n = costs.length -2; n >=0; n--)
        {
            costs[n][0] +=Math.min(costs[n+1][1],costs[n+1][2]);
            costs[n][1] +=Math.min(costs[n+1][0],costs[n+1][2]);
            costs[n][2] +=Math.min(costs[n+1][0],costs[n+1][1]);
        }
        if(costs.length == 0) return 0;
        return Math.min(Math.min(costs[0][0] , costs[0][1]), costs[0][2]);
    }
}

// Your code here along with comments explaining your approach
approach here is to check what paint I used for last house and based on that find the combinations 
and finally when I reach at top the best combination will be the minimum of the 3 given colors.