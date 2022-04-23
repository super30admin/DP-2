// Time Complexity : O(M*N) where M is the number of coins and N is the amount
// Space Complexity : O(M*N) where M is the number of coins and N is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins.length==0 || coins==null) return -1;

        int[][] dp= new int[coins.length+1][amount+1];

        for(int j=0; j<dp.length;j++){
            dp[j][0]=1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1; j<dp[0].length;j++){
                if(j<coins[i-1]) dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
