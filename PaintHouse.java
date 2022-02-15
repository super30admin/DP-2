/**

// Bottom up approach.
TC - O(h*c) where h is the number of houses and C is the number of colors.
SC - O(C) where c is the number of colors.

**/

class Solution {
    
    int prev[];
    
    public int minCost(int[][] costs) {
        
        prev = costs[0];
        
        for (int i=1; i<costs.length; i++)
        {
                int curr[] = new int[costs[0].length];
            
                // paint the house with red color
                curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);

                // paint the house with blue color
                curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);

                // paint the house with green color
                curr[2] = costs[i][2] + Math.min(prev[0], prev[1]);
            
            prev = curr;
        }
        
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}