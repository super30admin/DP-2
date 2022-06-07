class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        for(int i = n-2; i >=0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}

/*Recursive approach
class Solution {
    public int minCost(int[][] costs) {
    if(costs == null || nums.length == 0) return 0;
        int caseR = helper(nums,0,0,0);
        int caseB = helper(nums,0,1,0);
        int caseG = helper(nums,0,2,0);
        
        return Math.min(caseR, Math.min(caseG,caseB));
    }
    
    private int helper(int[][] nums, int r,int color, int minCosts){
        //base
        if(r == costs.length) return minCosts;
        //logic
        if(color == 0){
            return Math.min(helper(costs, r+1, 1, minCosts + costs[r][0]),
                            helper(costs, r+1, 2, minCosts + costs[r][0]));
        }
        if(color == 1){
            return Math.min(helper(costs, r+1, 0, minCosts + costs[r][1]),
                            helper(costs, r+1, 2, minCosts + costs[r][1]));
        }
        if(color == 2){
            return Math.min(helper(costs, r+1, 0, minCosts + costs[r][2]),
                            helper(costs, r+1, 1, minCosts + costs[r][2]));
        }
        return 9999;
    }
}*/