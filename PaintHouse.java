//time - O(m*n) m - costs.length, n - costs[0].length
//space - O(1)
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int m = costs.length;

        for(int r=m-2; r>=0; r--){
            costs[r][0] += Math.min(costs[r+1][1], costs[r+1][2]);
            costs[r][1] += Math.min(costs[r+1][0], costs[r+1][2]);
            costs[r][2] += Math.min(costs[r+1][0], costs[r+1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}