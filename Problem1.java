// Time Complexity : O(2^h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Problem1 {

    public static HashMap<String, Integer> map;

    public static int minCost(int[][] costs) {
        map = new HashMap<>();
        return Math.min(minCost(costs, 0, 0), Math.min(minCost(costs, 0, 1), minCost(costs, 0, 2)));
    }

    public static int minCost(int[][] costs, int n, int color) {
        if (!map.containsKey(getKey(n, color))) {
            if (n == costs.length) {
                return 0;
            }
            int totalCost = costs[n][color];
            if (color == 0) {
                totalCost += Math.min(minCost(costs, n + 1, 1), minCost(costs, n + 1, 2));
            } else if (color == 1) {
                totalCost += Math.min(minCost(costs, n + 1, 0), minCost(costs, n + 1, 2));
            } else {
                totalCost += Math.min(minCost(costs, n + 1, 0), minCost(costs, n + 1, 1));
            }
            map.put(getKey(n, color), totalCost);
        }
        return map.get(getKey(n, color));
    }

    private static String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }

    public static void main(String[] args) {
        int[][] costs = { { 7, 6, 2 } };
        System.out.println(minCost(costs));
    }
}