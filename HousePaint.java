class Solution {
    /**
     * Solve using DP. We can use 2D DP array but don't need as we just need precious row s0 1D array. But colours are constant so 3 veriables are good.
     * Bottom up DP. Kind of Brute force greedy from bottom and keeping min cost in 3 constants.
     * Time:O(n) n - houses
     * Space: O(1)
     */

    public int minCost(int[][] costs) {
        // edge
        if (costs == null || costs.length == 0) {
            return -1;
        }
        int len = costs.length;
        int rMin = costs[len - 1][0];
        int bMin = costs[len - 1][1];
        int gMin = costs[len - 1][2];

        // bottom up DP
        for (int i = len - 2; i >= 0; i--) {
            // remember not costs[i][0], it's cost untill now which is in rMin/bMin
            int rMinTemp = rMin;
            int bMinTemp = bMin;
            rMin = costs[i][0] + Math.min(gMin, bMin);
            bMin = costs[i][1] + Math.min(gMin, rMinTemp);
            gMin = costs[i][2] + Math.min(bMinTemp, rMinTemp);
        }
        return Math.min(rMin, Math.min(gMin, bMin));
    }
}
