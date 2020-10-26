// Time Complexity : O(N) where N is the no.of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We are  using the DP technique. We will be using bottom up approach and
 * store the minimum value for previous houses to paint  to solve the problem.
 * To paint the n-1 house with Red, we select min of cost for
 * Blue and Green for nth House. Then take the min of cost among last 3 houses
 */


public class PaintHouse {

    public int minCost(int[][] costs){
        int n = costs.length;
        if(costs==null || costs.length==0) return 0;
        int cR = 0, cB=0, cG=0;
        for(int i=0; i<n; i++){
            int tempR= cR, tempB = cB, tempG= cG;
            cR = costs[i][0] + Math.min(tempB, tempG);
            cB = costs[i][1] + Math.min(tempR, tempG);
            cG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(cR, Math.min(cB, cG));
    }
}