
// Time Complexity : Add : O(N * M)   N - Amount  M - Coins
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(coins, amount));
    }

    public static int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //When the amount is zero, there is only one way : no amount
        dp[0] = 1;

        for(int i=0; i<coins.length; i++){
            // Changes made from the denomination
            for(int j=coins[i]; j<amount + 1; j++){
                //Already added value + the previous combination of the denomination
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        return dp[amount];
    }

}
