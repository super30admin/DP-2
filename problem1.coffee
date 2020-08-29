#// https://leetcode.com/problems/coin-change-2/
#// Time Complexity : O(n^2) or O(NxM) where N is length [0..amount] and M is length of coins []
#// Space Complexity : O(NxM) we are creating a 2d array to save answers
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
# none very nice explanation in class
#
#
#// Your code here along with comments explaining your approach
change = (amount, coins) ->
  return 1 if amount == 0
  return 0 if coins.length < 1

  dp = Array(coins.length+1).fill(Array(amount+1))

  for i in [0..coins.length]
    dp[i][0] = 1

  for j in [1..amount]
    dp[0][j] = 0

  for i in [1..coins.length]
    for j in [1..amount]
      if j < coins[i-1] # indexes are not 1,2,5
        dp[i][j] = dp[i-1][j]
      else
        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]

  return dp[coins.length][amount]

#change(5, [1,2,5])
