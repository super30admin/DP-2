// Time Complexity : O(N * amount) ; where N is a length of coins array.
// Space Complexity : O(amount):to keep dp array.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}