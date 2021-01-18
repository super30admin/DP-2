class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int cRed = costs[0][0];
        int cBlue = costs[0][1];
        int cGreen = costs[0][2];
        for(int i = 1; i < n; i++){
            int tempr = cRed; int tempB = cBlue;
            cRed = costs[i][0] + Math.min(cGreen, cBlue); 
            cBlue = costs[i][1] + Math.min(tempr,cGreen);
            cGreen = costs[i][2] + Math.min(tempr,tempB);
        }
        return Math.min(cRed, Math.min(cGreen, cBlue));
    }
}