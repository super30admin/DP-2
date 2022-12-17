// Time Complexity: O(n) where n is the number of houses
// Space Complexity: O(1) since we are manipulating the cost array
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
/*
 * 1 - Start with the second last row. At each element in that row, find and add the minimum of the next row 
 * to current cost.
 * 2 - In the end, find the minimum at the top row that will give us the minimum cost. This is not a greedy approach
 * but rather an exhaustive one.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        for(int i = n - 2; i >= 0; i--)
        {
            costs[i][0] += Math.min(costs[i + 1][1],costs[i+1][2]);
            costs[i][1] += Math.min(costs[i + 1][0],costs[i+1][2]);
            costs[i][2] += Math.min(costs[i + 1][0],costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }
}
