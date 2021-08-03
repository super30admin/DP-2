//paint house
// Time Complexity :O(n)
// Space Complexity :(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        //Classic DP problem
        for(int i=costs.length-2;i>=0;i--)
        {
            for(int j=0;j<3;j++){
                costs[i][j]=Math.min(costs[i][j]+costs[i+1][(j+1)%3],costs[i][j]+costs[i+1][(j+2)%3]);
            }
            
            
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
        
            
        
    }
}

//coin change-2
//TC O(nm)
//SC O(mn)

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;            
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=(dp[i-1][j]+dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][amount];
        
        
    }
}
