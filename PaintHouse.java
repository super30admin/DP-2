// Time Complexity : O(n) n = number of houses; colors are constant = 3
// Space Complexity : O(1) as we are using 3 variables to store previous cost values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
/** Used exhaustive approach. In the tree, you have one option for each house,
 *  paint them R,B or G.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return -1;
        int n = costs.length;

        int costR = costs[n - 1][0];
        int costB = costs[n - 1][1];
        int costG = costs[n - 1][2];


        for (int i = n - 2; i >= 0; i--) {
            int tempR = costR;
            int tempB = costB;
            int tempG = costG;
            for (int j = 0; j < costs[i].length; j++) {
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
