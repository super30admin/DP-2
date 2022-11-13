// Time Complexity : O(m * n) where m is coins array size and  n is the amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
  if (coins.length === 0 || coins === null) {
    return 0;
  }
  var n = coins.length;
  // Create 2D Matrix
  var dp = new Array(n + 1);
  for (var i = 0; i <= n; i++) {
    dp[i] = new Array(amount + 1);
  }
  // Filling the first row with zeros
  for (var i = 0; i < n + 1; i++) {
    dp[i][0] = 1;
  }
  // Filling the first row with zeros except column 1
  for (var i = 1; i < amount + 1; i++) {
    dp[0][i] = 0;
  }

  for (var i = 1; i < n + 1; i++) {
    for (var j = 1; j < amount + 1; j++) {
      if (j < coins[i - 1]) {
        dp[i][j] = dp[i - 1][j];
      } else {
        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
      }
    }
  }
  return dp[n][amount];
};
