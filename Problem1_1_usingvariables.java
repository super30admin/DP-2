// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
       // int [][] dp = new int[n][3];
        int CostR = costs[n-1][0];
        int CostB = costs[n-1][1];
        int CostG = costs[n-1][2];

        for(int i = n-2; i>=0; i--)
        {    
            int tempR = CostR;
            int tempB = CostB;
            CostR = costs[i][0]+Math.min(CostB, CostG);
            CostB = costs[i][1]+Math.min(CostG, tempR);
            CostG = costs[i][2]+Math.min(tempR, tempB);
        }

        return Math.min(CostR, Math.min(CostB, CostG));
    }
}
