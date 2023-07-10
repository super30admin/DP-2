// Time Complexity :O(3n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We have used a 1D array of size 3. We have taken only three columns as the number of colors given are only 3. 
//We are starting from the last row of the costs matrix, storing it in the dp array. //column 0 is for red,1 is for blue and 2 is for green. Adding each column to the eligible elements of the previous row and the one that gives minimum cost is stored in the dp array

            
class Solution {
    public int minCost(int[][] costs) {
        
       if(costs==null || costs.length==0) return 0;
int n=costs.length;
       int[]dp=new int[3];
       dp[0]=costs[n-1][0];
       dp[1]=costs[n-1][1];
       dp[2]=costs[n-1][2];
       for(int i=n-2;i>=0;i--)
       {
           //since we are using dp[0] for finding dp[1] we will store it in a temp variable
           int temp=dp[0];
           dp[0]=costs[i][0]+Math.min(dp[1],dp[2]);
           int temp2=dp[1];
           dp[1]=costs[i][1]+Math.min(temp,dp[2]);
           dp[2]=costs[i][2]+Math.min(temp,temp2);
       }
       return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}


/*
Exhaustive approach

class Solution {
    public int minCost(int[][] costs) {
        
       if(costs==null || costs.length==0) return 0;
       // We will consider red to be in 0 column ,blue in 1 and green in 2
       int ColorR=helper(costs,0,0,0);
       int ColorB=helper(costs,0,1,0);
       int ColorG=helper(costs,0,2,0);
       return Math.min(ColorR,Math.min(ColorB,ColorG));
    }
    private int helper(int[][]costs,int i,int color,int min)
    {
        //base
        if(i==costs.length) return min;
        //logic
        if(color==0)
        {
            //we have taken i+1 so it goes to the next row, 1 is for blue and 2 is for green,then we have added minimum to cost at the current color
            return Math.min(helper(costs,i+1,1,costs[i][0]+min),
                            helper(costs,i+1,2,costs[i][0]+min));
        }
        if(color==1)
        {
            return Math.min(helper(costs,i+1,0,costs[i][1]+min),
                            helper(costs,i+1,2,costs[i][1]+min));
        }
        if(color==2)
        {
         return Math.min(helper(costs,i+1,0,costs[i][2]+min),
                            helper(costs,i+1,1,costs[i][2]+min));   
        }
        return 1000;
    }
}


2D- Matrix

class Solution {
    public int minCost(int[][] costs) {
        
       if(costs==null || costs.length==0) return 0;
int n=costs.length;
       int[][] dp=new int [n][3];
       dp[n-1][0]=costs[n-1][0];
       dp[n-1][1]=costs[n-1][1];
       dp[n-1][2]=costs[n-1][2];
       for(int i=n-2;i>=0;i--)
       {
           dp[i][0]=costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
           dp[i][1]=costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
           dp[i][2]=costs[i][2]+Math.min(dp[i+1][0],dp[i+1][1]);
       }
       return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}


*/