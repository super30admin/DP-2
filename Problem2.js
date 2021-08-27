// Time Complexity : O( m x n) m number of coin, n is the amount
// Space Complexity : O(n) n is amount
// Did this code successfully run on Leetcode : Yes

var change = function (amount, coins) {
    if (!coins) return 0;

    var dp = new Array(coins.length + 1);
    for (var i = 0; i < dp.length; i++) {
        dp[i] = new Array(amount + 1);
        dp[i][0] = 1;
    }

    for (let j = 1; j < dp[0].length; j++) {
        dp[0][j] = 0;
    }

    for (let i = 1; i < dp.length; i++) {
        for (let j = 1; j < dp[0].length; j++) {
            if (j < coins[i - 1]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
    }
    return dp[dp.length - 1][dp[0].length - 1];
};