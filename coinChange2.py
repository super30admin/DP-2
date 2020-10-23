# Time Complexity: O(n*amount)
# Space complexiity: O(amount) if recursiion stack is used 
def coinChange(amount,coins):
    dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
    print(dp)
    print(len(dp))
    print(len(dp[0]))
    for i in range(len(dp)):
        dp[i][0] = 1
    print(dp)
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if (j<coins[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
    return dp[len(dp)-1][len(dp[0])-1]

arr = [1,2,5]
amount = 11
amt = coinChange(amount,arr)
print(amt)