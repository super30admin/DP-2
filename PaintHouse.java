// Time Complexity : O(n) ~ O(3n) but we avoid constant
//                    as we have constant number of colors i.e 3
// Space Complexity : O(1) no extra space as we modified costs array in-place
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Followed approach of dp taught yesterday in class where in we try to find
 results based on what we saw previous, the only constraint here is that if we
 use one of the colors in prvious one then we can choose min from only other two*/

class PaintHouse
{
    public int minCost(int[][] costs)
    {
        int n = costs.length;// number of houses

        for(int row = 1; row < n; row++)
        {
          costs[row][0] = costs[row][0]
                          + Math.min(costs[row-1][1], costs[row-1][2]);
          costs[row][1] = costs[row][1]
                          + Math.min(costs[row-1][0], costs[row-1][2]);
          costs[row][2] = costs[row][2]
                          + Math.min(costs[row-1][0], costs[row-1][1]);
        }

        return Math.min(Math.min(costs[n-1][0], costs[n-1][1]), costs[n-1][2]);
    }
}
