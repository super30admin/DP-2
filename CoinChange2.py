# TC = O(m * n)
# SC = O(m * n)

# Same as coin change-1 but here we are calculating number of valid path. The changes are illustrated in the recursive way shown below:
# Recursive approach
# def coinChange(A, coins):
#     return helper(coins,A, ind)
# def helper(coins, A, ind):
#     # base
#     if A == 0: return 1
#     if A < 0 or ind == len(coins): return 0
#     # logic
#     case0 = helper(coins, A, ind+1)
#     case1 = helper(coins, A-coins[ind], ind)
#     return case0 + case1

class Solution:
    def change(self, amount, coins):
        if coins == None: return 0
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # zero case + (sub problem: instance before addition of this coin)
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]  
        return dp[len(dp)-1][len(dp[0])-1]