// Time complexity: O(N), where N is the length of costs array.
// Space complexity: O(1), no extra space is used. 

class Solution1 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0; 
        
        // add costs in a bottom up approach
        for(int i=costs.length-2; i>=0; i--) {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]); 
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]); 
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]); 
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2])); 
    }
}