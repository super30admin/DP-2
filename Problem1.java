// Time Complexity : O(n) where n is length of costs and we have constant number of colors
// Space Complexity : O(1) constant space as we only have three constant variables to modify
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;

        int redCost = costs[costs.length-1][0];
        int blueCost = costs[costs.length-1][1];
        int greenCost = costs[costs.length-1][2];

        for(int i = costs.length - 2; i >= 0; i--){
            //cost of red
            int tempRedCost = redCost;
            redCost = costs[i][0] + Math.min(blueCost, greenCost);
            //cost of blue
            int tempBlueCost = blueCost;
            blueCost = costs[i][1] + Math.min(tempRedCost, greenCost);
            //costs of green
            greenCost = costs[i][2] + Math.min(tempRedCost, tempBlueCost);
        }

        return Math.min(redCost, Math.min(blueCost, greenCost));

    }
}
