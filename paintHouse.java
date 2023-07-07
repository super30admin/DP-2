// Time Complexity : O(mn), m = number of colors, n = number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Implemnted a bottom up approach. At each house, we have 3 choices, red, blue and green. 
 * We will take the minimum of the other two colors and add the cost of the current color to it.
 * We will do this for all the houses and return the minimum of the last row.
 */


import java.util.Arrays;

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length, n = 3;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = costs[m-1][i];
        }
        
        System.out.print(Arrays.toString(dp));

        for(int i=m-2; i>=0; i--){
            int red = dp[0], blue = dp[1], green = dp[2];
            for(int j=0; j<n; j++){
                if(j==0){
                    dp[j] = costs[i][j] + Math.min(blue, green);
                }else if(j == 1){
                    dp[j] = costs[i][j] + Math.min(red, green);
                }else{
                    dp[j] = costs[i][j] + Math.min(red, blue);
                }
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
