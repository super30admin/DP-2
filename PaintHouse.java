// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Since we have repeated subproblems we use the DP array approach.
// We take the minimum cost path for every color choice.
// When we select a color we cannot select it for the next house, so out of the other 2 colors we get the min value by comparing them.

class Solution {
    public int minCost(int[][] costs) {
      

      if(costs==null||costs.length==0);
      int n=costs.length;      
      // instead of storing values in a matrix or mutating the array,
      // we store the costs in 3 variables and update with the new minimum
        
      int costR=costs[n-1][0];
      int costB=costs[n-1][1];
      int costG=costs[n-1][2];

       for(int i=n-2;i>=0;i--){ 

           int tempR=costR; //because the values are updated, we store in temp
           costR=costs[i][0] + Math.min(costB,costG);
        
           int tempB=costB;
           costB=costs[i][1] + Math.min(tempR,costG);
           
           costG=costs[i][2] + Math.min(tempR,tempB);
       }
        return Math.min(costR,Math.min(costB,costG));
    }
    
   
}