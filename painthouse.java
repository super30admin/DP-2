//Bottom up approach
//Time complexity: O(houses * colors)
//Space complexity: O(colors)
class Solution {
    public int minCost(int[][] costs) {
        
        int[] prev = costs[0];
        
        for(int i=1;i<costs.length;i++){
            
            int[] curr = new int[3];
            
            // cost of painting it RED
            curr[0] = costs[i][0] + Math.min(prev[1],prev[2]);
            // cost of painting it BLUE
            curr[1] = costs[i][1] + Math.min(prev[0],prev[2]);
            // cost of painting it GREEN
            curr[2] = costs[i][2] + Math.min(prev[0],prev[1]);
            
            prev = curr;
            
        }
        
        return Math.min(prev[0],Math.min(prev[1],prev[2]));
        
    }
}
//Top down approach
//Time complexity: O(houses * colors)
//Space complexity: O(houses * colors)
class Solution {
    private int[][] dp;
     public int minCost(int[][] costs) {
          dp = new int[costs.length][3];
         int h0Red = costs[0][0] + minCost(costs, 1 ,0);
         int h0Blue = costs[0][1] + minCost(costs, 1 ,1);
         int h0Green = costs[0][2] + minCost(costs, 1 ,2);
         
         return Math.min(h0Red,Math.min(h0Blue,h0Green));
     }
    
    public int minCost(int[][] costs, int index, int prevColor){
        //Base
        if(index==costs.length)
            return 0;
        
        if(dp[index][prevColor]>0)
            return dp[index][prevColor];
        
        if(prevColor==0){
            dp[index][prevColor] = Math.min(costs[index][1]+minCost(costs,index+1,1),costs[index][2]+minCost(costs,index+1,2));
        }
        if(prevColor==1){
            dp[index][prevColor] = Math.min(costs[index][0]+minCost(costs,index+1,0),costs[index][2]+minCost(costs,index+1,2));
        }
        if(prevColor==2){
            dp[index][prevColor] = Math.min(costs[index][1]+minCost(costs,index+1,1),costs[index][0]+minCost(costs,index+1,0));
        }
        
        return dp[index][prevColor];
        
    }
}
