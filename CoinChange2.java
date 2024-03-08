// Time Complexity : O(coinslength * amount)
// Space Complexity : O(coinslength * amount)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CoinChange2 {
    public int change(int amount, int[] coins) {

        // here we have to find all combinations of coins that will make amount
        int coinsLength = coins.length;
        int[][] dp = new int[coinsLength + 1][amount + 1];
        dp[0][0] = 1; // there is 1 way we can make 0 amount, simply by not choosing any coin

        for(int i = 1; i < dp.length; i++) { // iterating rows, denomination
            for(int j = 0; j < dp[0].length; j++) { // iterating columns, amount
                // if amount < denomination
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j]; // if amount is smaller than denomination, then current value will be same as in above matrix slot
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        // now simply return last row last column
        return dp[coinsLength][amount];

    }
}