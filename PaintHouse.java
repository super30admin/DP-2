// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class PaintHouse {
    public int minCost(int[][] costs) {
        int[][] dp=new int[costs.length][3];
         
            dp[0][0]=costs[0][0];
            dp[0][1]=costs[0][1];
            dp[0][2]=costs[0][2];
         
        for(int i=1;i<costs.length;i++){
            dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
         
         return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
     }
}
