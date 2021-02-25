// Time Complexity : O(n); n = #houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes(In the first place, it didnot strike that how I can build matrix to count min cost)

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;

        int houses = costs.length;

        for (int i = houses - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        int minCost1 = Math.min(costs[0][0], costs[0][1]);
        int minCost2 = Math.min(costs[0][1], costs[0][2]);

        return Math.min(minCost1, minCost2);
    }
}
