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