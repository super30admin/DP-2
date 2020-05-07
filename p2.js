// ## Problem2 (https://leetcode.com/problems/coin-change-2/)

// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

var change = function(amount, coins) {
    let dp = new Array(amount + 1).fill(0);
    dp[0] = 1;

    for (let i=0;i<coins.length;i++) { // iterate the types of coin
        for (let j=1;j<=amount;j++) {
            if (j >= coins[i]) {
                // dp[j] is the combinations for amount j for not using the current coin
                // dp[j - coins[i]] is is the combinations for using the current coin
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
    }
    return dp[amount];
}