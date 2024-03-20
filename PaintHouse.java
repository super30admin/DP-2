// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int cR = costs[n-1][0];
        int cB = costs[n-1][1];
        int cG = costs[n-1][2];

        for (int i = n-2; i >= 0; i++) {
            int tR = cR;
            cR = costs[i][0] + Math.min(cB, cG);
            int tB = cB;
            cB = costs[i][1] + Math.min(tR, cG);
            cG = costs[i][2] + Math.min(tR, tB);
        }

        return Math.min(cG, Math.min(cR, cB));
    }
}
