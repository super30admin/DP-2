// Time Complexity :O(m*n) --> beacuse of for loop
// Space Complexity :O(m*n)  ---> because of 2d array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't know how to approach even after coin change-1 problem. Not after session.


// Your code here along with comments explaining your approach

public class CoinChange2 {
    public static int coinChange2(int[] coins,int amount){
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 1;i<dp[0].length;i++)
            dp[0][i] = 0;
        for(int i = 0;i<dp.length;i++)
            dp[i][0] = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int  amount = 11;
        System.out.println(coinChange2(coins,amount));
    }
}
