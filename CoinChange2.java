// Time Complexity :O(m*n) where m = coins and n = amount
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach

public class CoinChange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            //Create dp array
            int[] dp = new int[amount +1];

            //set base case for zero amount
            dp[0] = 1;

            //Outter loop for coins and inner loop for amount
            for (int coin: coins) {
                for (int i = 1; i < dp.length; i++) {
                    if(i >= coin)
                        dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
