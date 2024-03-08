class Solution {

    /** Method 1
    TC -> O(m), where m = no of houses, since no of colors are constant
    SC -> O(1), Using the input array itself
    */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        // Number of Houses
        int m = costs.length;

        // Manipulating costs array itself.
        for(int i = m-2; i>=0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    /** Optimized DP, Using variables
    TC -> O(m), where m = no of houses, since no of colors are constant
    SC -> O(1), Using the input array itself
    */
    public int optimizedMinCost(int[][] costs){

        if(costs == null || costs.length == 0) return 0;
        
        // Number of Houses
        int m = costs.length, costR = costs[m-1][0], costG = costs[m-1][1], costB = costs[m-1][2];

        // Manipulating costs array itself.
        for(int i = m-2; i>=0; i--){
            int tempR = costR;
            costR = costs[i][0] + Math.min(costG, costB);
            int tempG = costG;
            costG = costs[i][1] + Math.min(tempR, costB);
            costB = costs[i][2] + Math.min(tempR, tempG);
        }
        return Math.min(costR, Math.min(costG, costB));
    }
}
