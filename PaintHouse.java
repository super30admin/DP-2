// Time Complexity: O(nm)
// Space Complexity: O(nm) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        // checking if the array is empty ot not
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        int n = costs.length; //#rows
        int m = costs[0].length; //#columns
        
        //declaring an array of size n*m
        int[][] dp = new int[n][m];
        
        //Copying the first row of costs to dp
        for(int j=0; j<m; j++){
            dp[0][j] = costs[0][j];
        }
        
        //Loop through the array to fill the min possible 
        // cost of each house when a particular color is chosen
        //for each cell, we add the corressponding value in costs array
        //and the min of values from previous row's other 2 colors values
        //example if read is chosen to house 2 then the cost of painting house in red 
        //and min value for painting house 1 blue or green
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(j == 0){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                }else if(j == 1){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                }else{
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        
        
        // return the min of last row values
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}