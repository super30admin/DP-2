// Time Complexity : O(m+n) m is the coins and n is 3 here
// Space Complexity : O(N) created a new 2d array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class Problem1 {

    public int minCost(int[][] costs){

        int n = costs.length;

        int[][] dp = new int [n][3];

        for(int j=0; j<3; j++){

            //same as the original matrix
            dp[n-1][j] = costs[n-1][j];
        }

       //moving from second last row
        for(int i=n-2; i>=0; i++ ){

            //when painting with red
            dp[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);

            //when painting with blue
            dp[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);

            //when with green
            dp[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);

        }

        //returning minimum value from top row
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
