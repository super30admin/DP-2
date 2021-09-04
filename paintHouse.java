// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Did not understand the approach to the problem, had to refer to lecture to understand the problem.

public class paintHouse {
    public int minCost(int [][] costs){
        // null case
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int caseR, caseB, caseG;

        caseR = helper(costs, 0,0,0);
        caseB = helper(costs, 0,1,0);
        caseG = helper(costs, 0,2,0);
        return Math.min(caseR, Math.min(caseB, caseG));
    }

    private int helper (int [][] costs, int row, int color, int minCost) {
        //base case
        if(row == costs.length) return minCost;


        if(color == 0) {
            return Math.min(helper(costs, row + 1, 1, minCost + costs[row][0]),
                            helper(costs, row + 1, 2, minCost + costs[row][0]));
        
        }
        if(color == 1) {
            return Math.min(helper(costs, row + 1, 0, minCost + costs[row][1]),
                            helper(costs, row + 1, 2, minCost + costs[row][1]));
        
        }
        if(color == 2) {
            return Math.min(helper(costs, row + 1, 1, minCost + costs[row][2]),
                            helper(costs, row + 1, 0, minCost + costs[row][2]));
        
        }
        return -1;
    }

}
