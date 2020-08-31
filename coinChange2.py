"""
Time = O(nm); n = number of coins, m = amount
space = O(nm); n = number of coins, m = amount
Successfully excecuted on leetcode
 
"""


# 2D array approach ----
class CoinChange:    
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0: 
            return 1         
        if amount < 0 or len(coins) == 0:
            return 0         
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        #print("dp",dp)
        for i in range(len(coins)+1):
            dp[i][0] = 1
        for j in range(1,amount+1):
            dp[0][j] = 0
            
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):                
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
        #print("dp", dp)
        return dp[-1][-1]


# 1D array approach --- 
class ChangeCoin:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0: 
            return 1 
        
        #If we are given amount negative or there are no coins given
        if amount < 0 or len(coins) == 0:
            return 0 
        
        dp = [0]*(amount+1)
        dp[0] = 1
        for coin in coins:
            for x in range(coin,amount+1):
                dp[x] += dp[x-coin]
        print("dp", dp)
        return dp[amount]