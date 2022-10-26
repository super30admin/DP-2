// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public int minCost(int[][] costs) {

        int[] prevMinCost = costs[0];

        for(int h = 1; h < costs.length; ++h){
            
            int[] currMinCost = new int[3];

            //for red color
            currMinCost[0] = costs[h][0] + Math.min(
                                            prevMinCost[1], // green
                                            prevMinCost[2]  // blue
                                        );
            
            // for green color
            currMinCost[1] = costs[h][1] + Math.min(
                                            prevMinCost[0], // red
                                            prevMinCost[2]  // blue
                                        );

            //for blue color
            currMinCost[2] = costs[h][2] + Math.min(
                                            prevMinCost[1], // green
                                            prevMinCost[0]  // red
                                        );                           

            prevMinCost = currMinCost;
        }
        return Math.min(
            prevMinCost[0],
            Math.min(prevMinCost[1], prevMinCost[2])
        );
    }
}
