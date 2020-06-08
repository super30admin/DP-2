//Follow up no extra space to be used
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
       
        //edge
        if(costs == null || costs.length == 0) return 0;
        
   
        
        for(int i = 1; i< n;i++){
            //red
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            //green
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            //blue
            costs[i][2] += Math.min(costs[i-1][0] ,costs[i-1][1]);    
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    }
}

/*
TimeComplexity O(m x n)  here m is no of colors and n is no of houses i.e O(3n) 
SpaceCompexity O(1) used same costs array
*/