# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity : O(N), N = number of houses or no of rows in the matrix
// Space Complexity : O(1), in-place calculations used, no extra space being used  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    public int minCost(int[][] costs) {
         //in place changes
        for(int i = costs.length -2; i>=0; i--)
        {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
            
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
            
        
    }
    
    
    
    /*public int minCost(int[][] costs) {
        int red = minCostPaint(0, 0, 0,  costs);
        int blue = minCostPaint(0, 1, 0, costs);
        int green = minCostPaint(0, 2, 0, costs);
        return Math.min(red, Math.min(blue, green));
    }
    
    private int minCostPaint(int row, int prevChoice, int cost, int[][] costs)
    {
        //base
        if(row >= costs.length ) return cost;
        
        //logic 
        if (prevChoice == 0)
        {
             //choose  blue
            int blue = minCostPaint(row+1, 1,  cost + costs[row][1], costs);
            //choose green
            int green = minCostPaint(row+1, 2, cost +costs[row][2], costs);
            
            return Math.min(blue, green);
            
        }
        else if (prevChoice == 1)
        {
            //choose red
            int red = minCostPaint(row+1, 0, cost + costs[row][0], costs);
            //choose green
            int green = minCostPaint(row+1, 2, cost +costs[row][2], costs);
            
            return Math.min(red, green);
        }
        else 
        {
            //choose red
            int red = minCostPaint(row+1, 0, cost + costs[row][0], costs);
            //choose  blue
            int blue = minCostPaint(row+1, 1,  cost + costs[row][1], costs);

            return Math.min(red, blue);
            
        }
    }*/
}
             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O( M * N), where M= amount, N = number of coin denominations 
// Space Complexity : O( M * N), comes from the size of the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
      
        int dp[][] = new int[coins.length+1][amount +1 ];
        
        dp[0][0] = 1;
        for(int i=1; i< dp.length; i++)
        {
            dp[i][0] = 1;
        }
        
        for(int i=1; i< dp.length; i++)
        {
            for (int j=1; j< dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] +  dp[i][j-coins[i-1]] ;
                }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length-1];
        return result;
        
        
      // return coinChange(0, coins, amount);
    }
    
   /* private int coinChange(int index, int[] coins, int amount)
    {
        //base 
        if (amount == 0)
            return 1;
        
        if(amount < 0 || index == coins.length)
            return 0;
        
        //case 1: we select the coin at index i 
        int includeCoin = coinChange(index,  coins, amount-coins[index]);
        
        //case 2: we do not select the coin at index i 
         int excludeCoin = coinChange(index +1 ,  coins, amount);
        
        
        
        return (includeCoin + excludeCoin);
        
    }*/
}
