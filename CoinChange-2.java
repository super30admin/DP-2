//Time complexity O(N*M) N is the no of coins and M is the total amount
//Space Complexity O(N*M) bcz we have buld a dp[][] 2-D arry od size (n+1)*(m+1)
//Successfully run in leetcode 

//Used Greedy method to solve

class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}