// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
//Approach: Solved the problem without mutating original array.

class HousrPaint {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        
        int lastR = costs[0][0];
        int lastB = costs[0][1];
        int lastG = costs[0][2];
        
        for (int i=1; i< costs.length; i++) {
            int currR = costs[i][0] + Math.min(lastB,lastG);
            int currB = costs[i][1] + Math.min(lastR,lastG);
            int currG = costs[i][2] + Math.min(lastR,lastB);
            
            lastB = currB;
            lastG = currG;
            lastR = currR;
        }
        
        int RBMin = Math.min(lastR, lastB);
        
        return Math.min(lastG,RBMin);
        
        
    }
    
    
}