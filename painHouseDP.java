//Compare previous row other two color min value
//and update the current value
public class painHouseDP {
    public  int minCost(int[][] nums)
    {
        //null
        if(costs == null || costs.length == 0 )return 0;
        int n = costs.length;
        //create a new dp with rows = no. of houses
        //columns = no of colors
        int [][] dp = new int[n][3];
        //first initialize the last row of dp with the array values as it is
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        //start from the 2nd last row from bottom and populate
        for(int i=n-2;i>=0;i--)
        {
            //if color 0 is selected then take the min cost of selecting colr 1 or color 2 from other row above
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    }
}
