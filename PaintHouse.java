// Time Complexity : O(nx3)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minCost(int[][] costs) {

        /*
        [[17,2,17],
        [16,16,5],
        [14,3,19]]
        */

        //constraints are : color and house

        int n = costs.length; //houses

        //We manipulate the input matrix instead of using a dp array
        //int[][] dp = new int[n][3];

        //We use bottom up dp

        //populate the last row with same values as input matrix
        // 14, 13, 19
        /*
        for(int j=0; j<=2; j++)
        {
            dp[n-1][j] = costs[n-1][j];
        }
        */

        //while filling the rest of the dp matrix we keep adding the cost of the color we choose to min of the other colors from next matrix row
        //to fill cell(1,0)(basically color house 1 as red) - we add 16 + (Min of (3,19)) :- can't choose 14 because that means house 2 is also red

        for(int i=n-2; i>=0; i--)
        {
            //if red is chosen for current row/house
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            //if blue is chosen for current row/house
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            //if green is chosen for current row/house
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }

        //answer will be min of the colors in first row of dp matrix

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }
}
