# Did this code successfully run on Leetcode : NO, TLE for some

# Approach: recursive
# TC: O(A^C)
# SC: O(C*A)

# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
        
#         def helper(amount, coins, track, result):
#             if amount == 0:
#                 result.add(tuple(sorted(track)))
#             if amount < 0:
#                 return
#             for c in coins:
#                 helper(amount-c, coins, track+[c], result)
#             return len(result)

#         return helper(amount, coins, [], set())

# DP Solution

# TC: O(C*A)
# SC: O(C*A)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # dp = [[0 for _ in range()]]
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        # print(dp)
        return dp[-1][-1]