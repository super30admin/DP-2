//// https://leetcode.com/problems/coin-change-2/
//// Time Complexity : O(n^2) or O(NxM) where N is length [0..amount] and M is length of coins []
//// Space Complexity : O(NxM) we are creating a 2d array to save answers
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// none very nice explanation in class

//// Your code here along with comments explaining your approach
var change;

change = function(amount, coins) {
  var dp, i, j, k, l, m, n, ref, ref1, ref2, ref3;
  if (amount === 0) {
    return 1;
  }
  if (coins.length < 1) {
    return 0;
  }
  dp = Array(coins.length + 1).fill(Array(amount + 1));
  for (i = k = 0, ref = coins.length; (0 <= ref ? k <= ref : k >= ref); i = 0 <= ref ? ++k : --k) {
    dp[i][0] = 1;
  }
  for (j = l = 1, ref1 = amount; (1 <= ref1 ? l <= ref1 : l >= ref1); j = 1 <= ref1 ? ++l : --l) {
    dp[0][j] = 0;
  }
  for (i = m = 1, ref2 = coins.length; (1 <= ref2 ? m <= ref2 : m >= ref2); i = 1 <= ref2 ? ++m : --m) {
    for (j = n = 1, ref3 = amount; (1 <= ref3 ? n <= ref3 : n >= ref3); j = 1 <= ref3 ? ++n : --n) {
      if (j < coins[i - 1]) {
        dp[i][j] = dp[i - 1][j];
      } else {
        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
      }
    }
  }
  return dp[coins.length][amount];
};

//change(5, [1,2,5])

//# sourceMappingURL=problem1.js.map
