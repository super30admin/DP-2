/*
Author: Akhilesh Borgaonkar
Problem: LC 256. Paint House (DP-2)
Approach: Using Dynamic Programming approach here to find the pattern of repeating sub-problems. 
Time Complexity: O(n) where m is number of houses
Space complexity: O(1) constant
LC verified
*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length<1)
            return 0;
        int costRed=costs[0][0], costBlue=costs[0][1], costGreen=costs[0][2];
        
        for(int i=1; i<costs.length; i++){
            int tempRed=costRed;
            int tempBlue=costBlue;
            int tempGreen=costGreen;
            
            costRed=Math.min(tempBlue, tempGreen) + costs[i][0];
            costBlue=Math.min(tempRed, tempGreen) + costs[i][1];
            costGreen=Math.min(tempRed, tempBlue) + costs[i][2];
        }
        int RBmin = Math.min(costRed,costBlue);
        return Math.min(RBmin, costGreen);
    }
}