// Time Complexity : O(amount*coins.length)
// Space Complexity : O(amount*coins.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        for(int coin = 1 ; coin < dp.length; coin++){
            int coinVal = coins[coin-1];
            for(int amt = 0; amt < dp[0].length; amt++){
                if(amt == 0){
                    dp[coin][amt] = 1;
                    continue;
                }
                int prev = amt-coinVal < 0 ? 0 : dp[coin][amt-coinVal];
                dp[coin][amt] = dp[coin-1][amt] + prev;
            }
        }

        return dp[coins.length][amount];
    }
}
