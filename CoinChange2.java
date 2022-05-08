// Time Complexity : O(N*M) where n is the number of coins and m is the amount
// Space Complexity : O(N*M) where n is the number of coins and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach


public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        dp[0][0] = 1;

        for(int i=0; i<coins.length+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j]; // amount less than the coin value (take the previous value)
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; // add the possibilities if we dont choose this coin and if we choose it (subtract the coin value from the amount and find the remaining amount's possibilities)
                }
            }
        }
        return dp[coins.length][amount];
    }
}
