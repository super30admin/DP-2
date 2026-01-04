// Time Complexity : O(costs len)
// Space Complexity : O(costs len)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
// We start bottom up, calculate at each step what's the min possible by taking prev sides sum
class Solution {

    public int minCost(int[][] costs) {
        //edge case
        if (costs.length == 0) return 0;

        int[][] memo = new int[costs.length + 1][3];
        //bottom-up, taking the min sum from prev two
        for (int i = costs.length - 1; i >= 0; --i) {
            memo[i][0] = costs[i][0] + Math.min(memo[i + 1][1], memo[i + 1][2]);
            memo[i][1] = costs[i][1] + Math.min(memo[i + 1][0], memo[i + 1][2]);
            memo[i][2] = costs[i][2] + Math.min(memo[i + 1][0], memo[i + 1][1]);
        }
        //return min of top
        return Math.min(Math.min(memo[0][0], memo[0][1]), memo[0][2]);
    }
}