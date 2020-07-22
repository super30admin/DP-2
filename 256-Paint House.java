//Time complexity=O(N) , N=No. of houses
//Space complexity=O(M*N), N=no. of houses, M=No. of colour
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here we are creating a matrix that stores all the possible combination of colouring the houses, So for the 1st house we are taking the cost as it is, Now for other we are adding the cost of the current house color to the minimum of the rest of the colours of the previous houses. And keep doing this till we reach the last house.  

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0 || costs==null)
            return 0;
        int[][] dp=new int[costs.length+1][costs[0].length+1];
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0]=Integer.MAX_VALUE;
        }
        int i=0;
        for(i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j>=dp[0].length-1)
                   dp[i][j]=costs[i-1][j-1]+Math.min(dp[i-1][j-1],dp[i-1][j-2]);
                else if(j<=1)
                    dp[i][j]=costs[i-1][j-1]+Math.min(dp[i-1][j+1],dp[i-1][j+2]);
                else
                    dp[i][j]=costs[i-1][j-1]+Math.min(dp[i-1][j-1],dp[i-1][j+1]);
            }
        }
        return Math.min(dp[i-1][1],Math.min(dp[i-1][3],dp[i-1][2]));
        
        }
}