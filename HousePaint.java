// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        //using dp ( compute the cost in the same arr)
        //null check
        if(costs == null || costs.length == 0) {
            return 0;
        }
        
       // choose blue, green , red house and then add cost of that house and min between other two adjacent houses
       for(int i = costs.length-2; i>=0 ;i--) {
           costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
           costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
           costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
       }
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }

   
}