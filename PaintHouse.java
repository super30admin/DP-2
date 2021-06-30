// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)  return 0;
        
        int prevRed = costs[costs.length - 1][0];
        int prevGreen = costs[costs.length - 1][1];
        int prevBlue = costs[costs.length - 1][2];
        
        for(int i=costs.length - 2; i>=0; i--){
            int tempRed = prevRed;
            int tempGreen = prevGreen;
            prevRed = costs[i][0] + Math.min(prevBlue, prevGreen);
            prevGreen = costs[i][1] + Math.min(prevBlue, tempRed);
            prevBlue = costs[i][2] + Math.min(tempRed, tempGreen);
        }
        
        return Math.min(prevRed, Math.min(prevGreen, prevBlue));
    }
}