// Time Complexity = O(n)
// Space Complexity = O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        
        for (int i = n-2 ; i >= 0; i --){
            int prevR = costR;
            costR =  costs[i][0] + Math.min(costB, costG);
            
            int prevB = costB;
            costB =  costs[i][1] + Math.min(prevR, costG);
            
            costG =  costs[i][2] + Math.min(prevR, prevB);
        }  
        return Math.min(costR, Math.min(costB,costG));
    }
}