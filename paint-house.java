// Time: O(n)
// Space: O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;
    
      int prevj = 0;
      int houses = costs.length;
      int colors = costs[0].length;
      for(int i=1;i<houses;i++){
       for(int j=0;j<colors;j++){
         // if there were n colors, another for loop here
          costs[i][j] = Math.min(costs[i][j] + costs[i-1][(j+1)%colors],costs[i][j] + costs[i-1][(j+2)%colors] );
       }  
      }
      
      
      int min = Integer.MAX_VALUE;
      for(int j=0;j<colors;j++){
        min = Math.min(min,costs[houses-1][j]);
      }
      return min;
      
    }
}
