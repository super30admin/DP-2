// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes  
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach
//calculated the min for every color at every house
class Solution {
    public int minCost(int[][] costs) {
        int[] mincurr = { 0, 0, 0 };
        for (int[] cost : costs) {
            int curr[] = mincurr.clone();
            mincurr[0] = cost[0] + Math.min(curr[1], curr[2]);
            mincurr[1] = cost[1] + Math.min(curr[2], curr[0]);
            mincurr[2] = cost[2] + Math.min(curr[0], curr[1]);
        }
        return Math.min(mincurr[0], Math.min(mincurr[1], mincurr[2]));
    }
}