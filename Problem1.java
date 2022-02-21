// Time Complexity : O(n) where n = number of houses
// Space Complexity : O(1) since number of colors are 3
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1 {
    public static int minCost(int[][] costs) {
        int[] prev = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int[] curr = new int[3];
            // Total cost if I paint the ith house red.
            curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);
            // Total cost if I paint the ith house green.
            curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);
            // Total cost if I paint the ith house blue.
            curr[2] = costs[i][2] + Math.min(prev[0], prev[1]);
            prev = curr;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int ans = minCost(costs);
        System.out.println(ans);
    }
}
