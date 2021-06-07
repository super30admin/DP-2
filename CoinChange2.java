
//Time Complexity: O(MN)
//Space Complexity: O(MN)

//Runtime: 20 ms, faster than 14.21% of Java online submissions for Coin Change 2.
//Memory Usage: 48 MB, less than 7.04% of Java online submissions for Coin Change 2.


class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i-1])
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];

            }
        }
        return dp[coins.length][amount];
    }
}
