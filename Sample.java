// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Coin change -2
//Recursive
//Time Complexity exponential 2 pow m+n
//space complexity o(m+n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        if(coins.length == 0 && amount == 0)
            return 1;
        return helper(amount, coins, 0);
    }
    
    private int helper(int amount, int[] coins, int i){
        //base case
        if(i>=coins.length || amount<0)
            return 0;
        if(amount == 0)
            return 1;
        //logic
        //not choosing the coin
        int case1 = helper(amount,coins,i+1);
        //choosing the coin
        int case2 = helper(amount-coins[i],coins,i);
        return case1+case2;
    }
}

//Tabulization
//Time complexity: o(mn)
//space" o(m+n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        if(coins.length == 0 && amount == 0)
            return 1;
        int m = coins.length+1, n = amount+1;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j] +dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//painting a house
//Time o(n)
//space: o(1) as i/p array size and created array size is same

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length==0)
            return 0;
        int m = costs.length, n = costs[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<n;i++)
            dp[0][i] = costs[0][i];
        
        for(int i=1;i<m;i++){
            //if I choose red for the previous house
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            //if I choose blue for the previous house
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            //if I choose green for the previous house
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
       return Math.min(dp[m-1][0],Math.min(dp[m-1][1],dp[m-1][2]));
    }
}