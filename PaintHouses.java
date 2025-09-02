// Time Complexity : O (m*n)
// Space Complexity : O(1) since we  know the number of colors to be 3
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Doing bottom-up approach where we keep the cost of painting last house as is and we start calculating the minimum cost at every level by comparing the cost of painting the house with specific color and constraint for not picking the same color for house below.
 * The first row's minimum will get us the cost for painting the house with minimum costs with adjacent houses not having the same color.
 */
class PaintHouses {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int result[] = new int[n];
        result[0] = costs[m-1][0];
        result[1] = costs[m-1][1];
        result[2] = costs[m-1][2];

        for (int i = m-2; i>=0; i--) {
            int tempR = result[0];
            int tempB = result[1];
            int tempG = result[2];

            result[0] = costs[i][0] + Math.min(tempB, tempG);
            result[1] = costs[i][1] + Math.min(tempR, tempG);
            result[2] = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(result[0], Math.min(result[1], result[2]));
    }
}