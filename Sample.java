// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
 
//Coin Change - 2
// Your code here along with comments explaining your approach
 
//Approach 1 with 1d array
 
class Solution {
    public int change(int amount, int[] coins) { 
    if(coins == null || coins.length == 0) return 0; //null case need to assign this first
       
        //n is column (amount) and m is length of array
        int m = coins.length;
        int n = amount;
       
        int[] dp = new int[n+1];
       
        // the first position is initialized with zero initially
       
        dp[0] = 1;
  
       
        for(int i=1;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(j >= coins[i-1])
                {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
       
        return dp[n];
    }
 }
  
  
//Approach 1 with 2d array
 
class Solution {
    public int change(int amount, int[] coins) { 
    if(coins == null || coins.length == 0) return 0; //null case need to assign this first
       
        //n is column (amount) and m is length of array
        int m = coins.length;
        int n = amount;
       
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
       
        // for(int j=1;j<dp[0].length;j++)
        // {
        //     dp[0][j] = 0;
        // }
       
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
       
        return dp[m][n];
    }
 }
  
 // Time Complexity : O(m * n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this : no
  
 //Paint house
// Your code here along with comments explaining your approach
 
//Approach 1 with DP Matrix
 
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n=costs.length;
        int[][] dp = new int[n][3];
        for(int j=0;j<3;j++)
        {
            dp[n-1][j]=costs[n-1][j];
        }
       
        for(int i=n-2;i>=0;i--)
        {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
       
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
 }
  
 // Approach 2 with same matrix
  
 class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n=costs.length;
       
        for(int i=n-2;i>=0;i--)
        {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
       
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
 
//Approach 3 with 3 variables
 
class Solution {
   public int minCost(int[][] costs) {
       if(costs == null || costs.length == 0) return 0;
       int n=costs.length;
       int costR = costs[n-1][0];
       int costB = costs[n-1][1];
       int costG = costs[n-1][2];
       int tempR, tempB;
       for(int i=n-2;i>=0;i--)
       {
           tempR = costR;
           tempB = costB;
           costR = costs[i][0] + Math.min(costB, costG);
           costB = costs[i][1] + Math.min(tempR, costG);
           costG = costs[i][2] + Math.min(tempR, tempB);
       }
      
       return Math.min(costG, Math.min(costB, costR));
   }
}
 