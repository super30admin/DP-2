//Mention the following in your submissions:
// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes



class Solution {
    public int minCost(int[][] costs) {
        int costR, costB, costG;
        
        costR = costs[costs.length-1][0];
        costB = costs[costs.length-1][1];
        costG = costs[costs.length-1][2];
        
        for(int i= costs.length-2;i>=0;i--)
        {
            int tempR = costR;
            int tempB = costB;
            
          costR=  costs[i][0]+ Math.min(costB,costG);
          costB = costs[i][1]+ Math.min(tempR,costG);
          costG = costs[i][2]+Math.min(tempR,tempB);  
            
        }
        
        return Math.min(costR,Math.min(costB,costG));
    }
}