class Solution {
    public int minCost(int[][] costs) {
        int colorR = helper(costs, 0, 0);
        int colorB = helper(costs, 0, 1);
        int colorG = helper(costs, 0, 2);

        return Math.min(colorR, Math.min(colorG, colorB));
    }

    private int helper(int[][] costs, int i, int j) {
        if (j == 0) {
            return costs[i][0] + Math.min(helper(costs, i+1, 1), helper(costs, i+1, 2));
        } else if (j == 1) {
            return costs[i][0] + Math.min(helper(costs, i+1, 0), helper(costs, i+1, 2));
        } else {
            return costs[i][0] + Math.min(helper(costs, i+1, 0), helper(costs, i+1, 1));
        }
    }
}