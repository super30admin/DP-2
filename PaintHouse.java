//  Time complexity: O(3n)
//  Space Complexity: O(1)

class Solution {
    public int minCost(int[][] costs) {
        
        int m = costs.length;
        int n = costs[0].length;
        int r = costs[m-1][0];
        int b = costs[m-1][1];
        int g = costs[m-1][2];

        
        for(int i=m-2; i>=0; i--){
            int tempr = r, tempb = b, tempg = g;
            r = costs[i][0] + Math.min(tempb, tempg);
            b = costs[i][1] + Math.min(tempr, tempg);
            g = costs[i][2] += Math.min(tempr, tempb);
        }
        return Math.min(r,Math.min(g,b));        
    }
}