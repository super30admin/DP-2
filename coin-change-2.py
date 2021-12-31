class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        #DP
        dp = [[0]*(amount+1)]*(len(coins)+1)
        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j]

        return dp[-1][-1]
        

        #Exhaustive Approach
#         def helper(amount, coins, index, memo):
#             #memo
#             if memo.has_key((index, amount)):
#                 return memo[(index, amount)]
#             # Base Condition
#             if amount == 0: return 1
#             if ((amount < 0) or (index == len(coins))): return 0
#             # Logic
#             memo[(index, amount)] = (helper((amount-coins[index]), coins, index, memo) + helper(amount, coins, index+1, memo))
#             return memo[(index, amount)]
#             # return self.count

#         return helper(amount, coins, 0, {})