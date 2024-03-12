// Time Complexity : m*n where m is the colors and n is the houses. In this question, we have 3 colors so it becomes. 3n. It will be O(n). 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/paint-house/description/
// Any problem you faced while coding this : No

public class MyClass {
    public static void main(String args[]) {
     int[][] costs = { 
         {17,2,17},{16,16,5},{14,3,19} 
     };
     int n = costs.length;
     int[][] dp = new int[n][3];
     dp[n-1][0] = costs[n-1][0];
     dp[n-1][1] = costs[n-1][1];
     dp[n-1][2] = costs[n-1][2];
     for(int i=n-2;i>=0;i--){
         dp[i][0] = costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
         dp[i][1] = costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
         dp[i][2] = costs[i][2]+Math.min(dp[i+1][0],dp[i+1][1]);
     }
     int result = Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
     System.out.println(result);
    }
}
