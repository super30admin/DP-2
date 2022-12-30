// Time Complexity : O(3n) or O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Since we see a repeated subproblem pattern here we can solve it with DP
//Repeated subproblem - There are three options for colors. We find the min cost path for each of these three colors and then return the min.
//Once we have selected one color we know that we cannot repeat it so we have two other options out of which we need to choose min. 


class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tempR = costR;
            int tempB = costB;
            int tempG = costG;
            costR = costs[i][0] + Math.min(costB, costG);
            costB = costs[i][1] + Math.min(tempR, tempG);
            costG = costs[i][2] + Math.min(tempB, tempR);
        }

        return Math.min(costR, Math.min(costB, costG));
    }
}