// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class PaintHouse {
    public int minCost(int[][] costs) {
        //no. of houses
        int n = costs.length;
        //filling last row with the same values in costs
        int costRed = costs[n-1][0];
        int costBlue = costs[n-1][1];
        int costGreen = costs[n-1][2];
        for(int i=n-2; i>=0; i--){
            int tempR = costRed;
            costRed = costs[i][0] + Math.min(costBlue,costGreen);
            int tempB = costBlue;
            costBlue = costs[i][1] + Math.min(tempR,costGreen);
            costGreen = costs[i][2] + Math.min(tempB,tempR);
        }
        return Math.min(costRed, Math.min(costBlue, costGreen));
    }
}