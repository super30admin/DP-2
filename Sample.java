//****PAINT HOUSE: DP APPRAOCH****
//Time complexity: colors: 3  * rows:m , 
//therefore it is o(m*3) i.e :  0(m);
//Space complexity: 0(1);
//Leetcode runnable: Y;

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n=costs.length;
        
        for(int i=n-2;i>=0;i--)
        {
            costs[i][0] +=  Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] +=  Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] +=  Math.min(costs[i+1][0], costs[i+1][1]);
        }
        
        //find min in the top row
         return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        
    }
}

//****PAINT HOUSE: RECURSIVE APPRAOCH****
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length== 0) return 0;
        
        int caseR=helper(costs, 0, 0, 0 );
        int caseB=helper(costs, 0, 1, 0 );
        int caseG=helper(costs, 0, 2, 0 );
        
        return Math.min(caseR, Math.min(caseB, caseG));
        
        
    }
    
    private int helper(int[][] costs, int r, int color, int mincost)
    {
        //Base
        if(r==costs.length)
        {
            return mincost;
        }
        
        //logic 
        if(color==0)
        {
            return Math.min(helper(costs, r+1, 1, mincost+costs[r][0]),helper(costs, r+1, 2,                     mincost+costs[r][0]));
        }
        
        if(color==1)
        {
            return Math.min(helper(costs, r+1, 0, mincost+costs[r][1]),helper(costs, r+1, 2,                     mincost+costs[r][1]));
        }
                            
        if(color==2)
        {
            return Math.min(helper(costs, r+1, 0, mincost+costs[r][2]),helper(costs, r+1, 1,                     mincost+costs[r][2]));
        }
        return 8282;
    }
}

//****COIN CHANGE:2 : DP APPRAOCH ****
//time complexity: o(m*n) : m is amount and n is coins
//space complexity:0(1)
//leetcode runnable: Y;
class Solution {
    public int change(int amount, int[] coins) {
        int m= coins.length;
        int n= amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=1;
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+ dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

//****COIN CHANGE:2 RECURSIVE APPROACH
//time complexity: o(m*n) : m is amount and n is coins
//space complexity:0(1)
//leetcode runnable: TLE ERROR
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        
        
        return helper(amount, coins, 0);
        
    }
    
    private int  helper(int amount, int[] coins, int i)
    {
        //Base case
        if(amount==0) return 1;
        if(amount<0 || i==coins.length) return 0;
        
        //Logic
        
        //To choose
        int case1= helper(amount-coins[i], coins, i);
        
        //Not to choose
        int case2=helper(amount, coins, i+1);
        
        return case1+case2;
        
    }
    
}
