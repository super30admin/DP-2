/**
## ## Problem1(https://leetcode.com/problems/paint-house/)
 
Time Complexity :   O (M * N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (256. Paint House)
Any problem you faced while coding this :       No
 */

 // Bottom up approach
 class PaintHouse {
    public int minCost(int[][] costs) {
        if ( costs == null || costs.length == 0 )
            return 0;
        
        int n = costs.length;   
        int[][] dp = new int[n][3];
        
        // copy the last row 
        for( int col = 0; col < 3; col++){
            dp[n-1][col] = costs[n-1][col];
        }
        
        // add current value + min value of other 2 rows
        for( int row = n-2; row >= 0; row--){
            dp[row][0] = costs[row][0] + Math.min(dp[row+1][1], dp[row+1][2]);
            dp[row][1] = costs[row][1] + Math.min(dp[row+1][0], dp[row+1][2]);
            dp[row][2] = costs[row][2] + Math.min(dp[row+1][1], dp[row+1][0]);
        }
        
        // return min from all 3 columns
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
    
    public static void main(String args[]) 
    { 
        PaintHouse obj = new PaintHouse();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(obj.minCost(costs));
    }
}