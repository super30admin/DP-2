// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class ColorHouses {

    public int minCost(int[][] cost) {

        // check if the input is proper to traverse
        if (cost == null || cost.length == 0 || cost[0].length == 0) {
            return 0;
        }

        int n = cost.length;

        // replace the current value with min uptill now
        for (int i = 1; i < n; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][1], cost[i - 1][0]);
        }

        return Math.min(cost[n - 1][0], Math.min(cost[n - 1][1], cost[n - 1][2]));
    }

}
