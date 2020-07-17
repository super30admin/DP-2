class Solution {
    public int minCost(int[][] costs) {
        int case0 = helper(costs, 0, 0, 0); //red
        int case1 = helper(costs, 0, 0, 1); //blue
        int case2 = helper(costs, 0, 0, 2); //green
        
        return Math.min(case0, Math.min(case1, case2));
    }
    
    public int helper(int[][] costs, int min, int row, int lastColour){
        if(row == costs.length) return min;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
        
        //red
        if(lastColour==0)
         case1 = Math.min(helper(costs, min+costs[row][1], row+1, 1), //blue
                            helper(costs, min+costs[row][2], row+1, 2)); //green
        
        //blue
        if(lastColour==1)
         case2 = Math.min(helper(costs, min+costs[row][0], row+1, 0), //red
                            helper(costs, min+costs[row][2], row+1, 2)); //green
        
        //green
        if(lastColour==2)
         case3 = Math.min(helper(costs, min+costs[row][0], row+1, 0), //red
                            helper(costs, min+costs[row][1], row+1, 1)); //blue
        
        return Math.min(case1, Math.min(case2, case3));
        
        
    }
}
