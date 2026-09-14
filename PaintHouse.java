// Time Complexity : O(3n) or O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int cr = costs[n-1][0];
        int cb = costs[n-1][1];
        int cg = costs[n-1][2];

        for (int i= n-2; i>=0; i--){
            int tempR = cr;
            cr = costs[i][0] + Math.min(cb, cg);
            int tempB = cb;
            cb = costs[i][1] + Math.min(tempR,cg);
            cg = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(cr, Math.min(cb, cg));
    }
}