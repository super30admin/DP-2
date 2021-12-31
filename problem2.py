# Time Complexity O (m*n)
# Space Complexity O (m*n)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[0 for c in range(amount+1)] for r in range(len(coins)+1)]
        for x in range(len(coins) + 1):
            dp[x][0] = 0
            
        for y in range(1, len(dp)):
	        dp[y][0] = 1
        for x in range(1,len(dp)):
            for y in range(1,len(dp[0])):
                if y < coins[x-1]:
                    dp[x][y] = dp[x-1][y]
                else:
                    dp[x][y] = dp[x-1][y] + dp[x][y-coins[x-1]]
        # if dp[-1][-1]>= 9999:
        #     return -1
        return dp[-1][-1]
        
        
#         dp = [[0 for c in range(amount+1)] for r in range(len(coins)+1)]
        
#         for x in range(len(coins)+1):
#             dp[0][x] = 0
            
#         dp[0][0] = 1
            
#         for x in range(len(dp[0])):
#             dp[1][x]=1
            
#         for x in range(1,len(dp)):
#             dp[x][0]=1
#             for y in range(1,len(dp[0])):
#                 if y < coins[x-1]:
#                     dp[x][y] = dp[x-1][y]
#                 else:
#                     dp[x][y] = dp[x-1][y]+dp[x][y - coins[x-1]]
        
#         return dp[-1][-1]
        
        
        
        
        
        
        
        
