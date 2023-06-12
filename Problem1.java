// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the number of houses(rows in the given in 2D array)

// Your code here along with comments explaining your approach
    //We use 3 variables each stating the minimum cost that is needed to paint the current house in each colors.
    //As we cannot paint a current house with same color as previous house, we must consider the minimum of the cost required to paint the current house in any of the 2 different colors.
    //After traversing all the rows, we end up with the minimum cost required to paint the last house in each of the colors. The minimum of them is the answer.

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int costR = costs[0][0];
        int costG = costs[0][1];
        int costB = costs[0][2];
        for (int i=1; i<n; i++)
        {
            int prevR = costR;
            int prevG = costG;
            costR = costs[i][0] + Math.min(costG, costB);
            costG = costs[i][1] + Math.min(prevR, costB);
            costB = costs[i][2] + Math.min(prevR, prevG);
        }
        return Math.min(costR, Math.min(costG, costB));
    }
}