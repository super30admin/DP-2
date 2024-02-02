// Time Complexity : O(n) n = number of houses; colors are constant
// Space Complexity : O(1) as we are using 3 variables to store previous cost values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
/* Used exhaustive approach to create the tree. In the tree, you have one option for each house,
*  paint them R,B or G. Constructed that tree into a matrix (matrix optimized into 3 variables).
*/

class Problem1 {
    public int minCost(int[][] costs) {
        // invalid costs array
        if (costs == null || costs.length == 0)
            return -1;
        // houses
        int n = costs.length;

        // prefilling last house values
        // consider only one house; min values to paint one house r,g or b will be
        // the cost to paint it r, g or b
        int costR = costs[n - 1][0];
        int costB = costs[n - 1][1];
        int costG = costs[n - 1][2];

        // for 2 or more houses
        for (int i = n - 2; i >= 0; i--) {
            // making copies of the variables as we are overwriting them
            int tempR = costR;
            int tempB = costB;
            int tempG = costG;
            for (int j = 0; j < costs[i].length; j++) {
                // if calculating for color = 0 (red); pick min from (blue) and green
                if (j == 0) {
                    costR = costs[i][j] + Math.min(tempB, tempG);
                } else if (j == 1) {
                    costB = costs[i][j] + Math.min(tempR, tempG);
                } else {
                    costG = costs[i][j] + Math.min(tempR, tempB);
                }
            }
        }

        return Math.min(costR, Math.min(costB, costG));
    }
}