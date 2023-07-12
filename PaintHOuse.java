class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int r = costs[n-1][0];
        int b = costs[n-1][1];
        int g = costs[n-1][2];

        for(int i = n-2; i>=0; i--){
            int tempr = r;
            int tempb = b;
            r = Math.min(b,g)+ costs[i][0];
            b = Math.min(tempr,g)+ costs[i][1];
            g = Math.min(tempb,tempr)+ costs[i][2];
        }

        return Math.min(r,Math.min(g,b));
        
    }
}