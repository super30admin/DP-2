//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n =costs.length;
        int cr = costs[n-1][0];
        int cb = costs[n-1][1];
        int cg = costs[n-1][2];
        for(int i = n-2; i >=0; i--) {
            int tr = cr;
            int tb = cb;
            cr = costs[i][0] + Math.min(cg, cb);
            cb = costs[i][1] + Math.min(tr, cg);
            cg = costs[i][2] + Math.min(tr, tb);
        }
        return Math.min(cr, Math.min(cb,cg));
    }
}
