/*
Time Complexity - O(N) where is the number of houses.
Space Complexity - O(1)
*/
class Solution {
    public int minCost(int[][] costs) {
     
        if(costs == null || costs.length == 0)
            return 0;
        
        int R = costs[0][0];
        int G = costs[0][1];
        int B = costs[0][2];
        
        for(int i = 1; i < costs.length; i++) 
        {
            int tempR = Math.min(G, B) + costs[i][0];
            int tempG = Math.min(R, B) + costs[i][1];
            int tempB = Math.min(R, G) + costs[i][2];
            
            R = tempR;
            G = tempG;
            B = tempB;  
        }
        
     return Math.min(Math.min(R,G),B) ;  
    }
}
