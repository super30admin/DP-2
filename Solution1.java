// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I created a dp array of the same size as that of the costs array and copied the elements of first row from costs array. Every element from the second row is calculated as the 
 * sum of costs at that particular position and the minimum of elements of dp array belonging to the above row but other two columns. 
 */

class Solution1 {
    public int minCost(int[][] costs) {
        int rows = costs.length;
        int columns = costs[0].length;

        int dp[][] = new int[rows][columns];
        for(int i=0;i<columns;i++)
        {
            dp[0][i]=costs[0][i];
        }

        for(int i=1;i<rows;i++)
        {
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[rows-1][0],Math.min(dp[rows-1][1],dp[rows-1][2]));

    }
}