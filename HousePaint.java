// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : couldnt run because problem is open only for paid users
// Any problem you faced while coding this :no

// at every house we decide minimum cost by taking into account the sum of cost of painting that house with one of the 3 colors and the min cost of  coloring the 
previous house with either of the remaining 2 colors.

// in the end we return the minimum value from the last row .
class Solution{
  
  public static int cost(int[][] cost)
  {
  
    if(cost == null || cost.length == 0)
      return 0;
      
    for(int i = 1 ; i < cost.length ; i++)
    {
        
        cost[i][0] = Math.min( cost[i-1][1], cost[i-1][2]) + cost[i][0];
        cost[i][1] = Math.min( cost[i-1][0], cost[i-1][2]) + cost[i][1];
        cost[i][2] = Math.min( cost[i-1][0], cost[i-1][1]) + cost[i][2];
        
    }
    
    return ( Math.min (Math.min( cost[cost.length-1][0],cost[cost.length-1][1]), cost[cost.length-1][2]));
    
  }
  

}
