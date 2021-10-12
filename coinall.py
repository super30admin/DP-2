class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        # DP
        #SC O(mn) m coins n amount
        # TC O(mn) m coins n amount
        dp = [[0] * (amount + 1) for i in range( len(coins) + 1)]
        for i in range(len(coins) + 1):
            dp [i][0] = 1
        for i in range(1,len(dp)):
            for j in range(1, amount + 1):
                
                # Whenevr j less than coin amount
                if j < coins[i -1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # 0 case + 1 case
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[len(dp)-1][len(dp[0])-1]
        
        # Exhaustive
#         def helper(coins, amount, ind):
            
#             #base
#             if amount == 0:
#                 return 1
#             if  amount < 0 or index == len(coins) :
#                 return 0
            
#             #logic
#             # dont choose
#             case1 = helper(coins, amount, ind + 1)
            
#             # choose
#             case2 = helper(coins, amount - coins[ind], ind)
            
#             return( case1 + case2)
            
            
#         return helper (coins, amount, 0)
