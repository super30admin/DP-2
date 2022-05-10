#Time Complexity : O(MN), where M represents the len(coins) and N represents the Amount 
#Space Complexity :O(N), where N is Amount
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#CODE:
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
#         dp = [[0 for x in range(amount+1)] for _ in range(len(coins)+1)]
#         for i in dp:
#             i[0] = 1
        
#         for i in range(1,len(dp)):
#             for j in range(1,len(dp[0])):
#                 if j < coins[i-1]:
#                     dp[i][j] = dp[i-1][j]
#                 else:
#                     dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
#         print(dp)
#         return dp[-1][-1]


        dp = [0 for x in range(amount+1)]
        dp[0] = 1
        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
        return dp[-1]
        