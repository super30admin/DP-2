/*TC - O(M^2)
 *SC - O(N^2)
 Ran on leetcode - yes
 * */

public class Solution {
public int minCost(int[][] costs) {
    // null scenario
    if (costs == null) return 0;
    
    // dp array initilaization row - houses , columns is the color
    int [][] dp = new int[costs.length+1][costs[0].length+1];
    
    // first row and first column zero
    for (int i = 0 ; i < dp.length; i++) {
        dp[i][0] = 0;
    }
        
    for (int i = 0 ; i < dp[0].length; i++) {
        dp[0][i] = 0;
    }
    
    for(int i=1; i < dp.length; i++){
        // red color , evaluate cost of coloring house red
        dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1],dp[i-1][2]);
        //blue color
        dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0],dp[i-1][2]);
        // green color 
        dp[i][2] = costs[i-1][2] +Math.min(dp[i-1][1],dp[i-1][0]);
    }
    
    // last rows contains the min cost required for the house to be colored
    return Math.min(Math.min(dp[dp.length-1][0], dp[dp.length-1][1]), dp[dp.length-1][2]);
}
}




