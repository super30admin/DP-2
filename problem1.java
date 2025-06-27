// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: At each step, we have 2 choices, I store the minimum I get from these
// The next values would be dependent on the minimums I get for choosing any color

class Solution {

    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int[][] mem = new int[costs.length + 1][3];
        for (int i = costs.length - 1; i >= 0; --i) {
            mem[i][0] = costs[i][0] + Math.min(mem[i + 1][1], mem[i + 1][2]);
            mem[i][1] = costs[i][1] + Math.min(mem[i + 1][0], mem[i + 1][2]);
            mem[i][2] = costs[i][2] + Math.min(mem[i + 1][0], mem[i + 1][1]);
        }
        return Math.min(Math.min(mem[0][0], mem[0][1]), mem[0][2]);
    }
}