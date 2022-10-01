
/*Solution: Dynamic Programming (Bottom Up DP)
* 1. Last row as a reference row => copy directly to DP array (Last row)
  2. Start from second last row and check for the min cost
  3. Total min Cost at element = 
        3.1 If Red = Current Red cost + Min from next row(cost of green + cost of blue)
        3.2 If Green = Current Green cost + Min from next row(cost of Red + cost of blue)
        3.3 If Blue = Current Blue cost + Min from next row(cost of green + cost of Red)
   4. Return min cost from first row as a answer. 
*/

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }     
        
        int m = costs.length; //rows of houses
        int n = costs[0].length; //columns of colors
        
        int[][] dp = new int[m][n];
        
        //copy last row to DP array
        for(int i = 0; i < n; i++){
            dp[m-1][i] = costs[m-1][i];
        }
        
        //Start from second last column and get min costs from next row
        for(int i = m-2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]); //Red
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]); //Green
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]); //Blue
        }
        
        //Return min from first row
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}