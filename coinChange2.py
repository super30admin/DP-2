# Time complexity : O(n*m) where n is the length of coins array and m is the amount
# Space complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : clear concepts after class

def coinChange(amount, coins):
    n = len(coins)+1
    m = amount+1
    dp = [[0 for j in range(m)] for i in range(n)]

    # initialize first col with 1
    for i in range(n):
        dp[i][0] = 1

    for i in range(1, n):
        for j in range(1, m):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
    return dp[n-1][m-1]


print(coinChange(5, [1, 2, 5]))
print(coinChange(0, [1, 2]))
