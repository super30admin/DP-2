// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;
        
        int green = costs[0][0];
        int blue = costs[0][1];
        int red = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int[] cost = costs[i];
            int newGreen = Math.min(red, blue) + cost[0];
            int newBlue = Math.min(green, red) + cost[1];
            int newRed = Math.min(green, blue) + cost[2];
            green = newGreen;
            blue = newBlue;
            red = newRed;
        }
        return Math.min(green, Math.min(blue, red));
    }
}