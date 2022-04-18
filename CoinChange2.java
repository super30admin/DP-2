// Time Complexity : O(n)
// Explaination : n is length of nums as we go through the array once
// Space Complexity : O(n)
// Explaination : aux array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Time taken : 10

import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0)
            return 0;

        // Cache for making till X amount
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        // 0 coins to make 0 amount
        dp[0] = 0;

        // dp[0] already filled so starting with dp[1]
        for (int coin : coins){
            // for each amount value till amount, check each coin
            for (int currAmt = coin; currAmt<=amount; currAmt++){
                if (currAmt-coin >= 0){
                    // 1+... to consider current coin
                    dp[currAmt] += dp[coin-currAmt];
                }
            }
        }
        // if last val in array is still max, means we didnt find the solution
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}
