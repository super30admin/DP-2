//tc=O(n)
//sc=O(n)
public class Solution {
    public int solve(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int cR = 0;
        int cG = 0;
        int cB = 0;
        int n = cost.length;
        for (int i = n -2; i >= 0; i --) {
            cost[i][0] = cost[i][0] + Math.min(cost[i+1][1], cost[i+1][2]);
            cost[i][1] = cost[i][1] + Math.min(cost[i+1][0], cost[i+1][2]);
            cost[i][2] = cost[i][2] + Math.min(cost[i+1][0], cost[i+1][1]);
        }
        
        return Math.min(cost[0][0], Math.min(cost[0][1], cost[0][2]));
        
    }
}
