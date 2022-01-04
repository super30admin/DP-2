// Time Complexity : Linear O(n), where n is number of houses
// Space Complexity : Linear O(n), where n is number of houses (can be optimized to constant)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
class Solution {
    public int minCost(int[][] costs) {
        int[][] ans = new int[costs.length][3];
        ans[0] = costs[0];
        
        for(int i=1; i<costs.length; i++) {
            ans[i][0] = Math.min(ans[i-1][1], ans[i-1][2]) + costs[i][0];
            ans[i][1] = Math.min(ans[i-1][0], ans[i-1][2]) + costs[i][1];
            ans[i][2] = Math.min(ans[i-1][0], ans[i-1][1]) + costs[i][2];
        }
        
        return Math.min(Math.min(ans[costs.length-1][0], ans[costs.length-1][1]), ans[costs.length-1][2]);
    }
}
