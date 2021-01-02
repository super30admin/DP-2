// Time Complexity :O(3n) = O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach


public class PaintHouse {

    class Solution {
        public int minCost(int[][] costs) {
            //return 0 when there is no value or null
            if(costs == null || costs.length == 0) return 0;

            //base case for when no houses to paint is costs[0], using tablulation DP method to build array from bottom
            //up starting at costs[0] and storing computed values in costs[costs.length-1].
            for (int i = 1; i < costs.length; i++) {
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
            }

            //Look in costs[costs.length-1] for the min costs
            return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
        }
    }
}