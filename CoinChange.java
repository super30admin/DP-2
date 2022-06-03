// Time Complexity : O(m*n) where n is total amount and m is number of coins.
// Space Complexity : O(m*n) where n is total amount and m is number of coins.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was able to think through since this was similar to previous coin change
// but couldn't code completely again.

class CoinChange {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String [] args){
        CoinChange cc = new CoinChange();
        System.out.println(cc.change(11,new int[]{1,2,5}));
    }
}