"""
Time Complexity : O(mn)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def change(self, amount, coins):
        # 1-d list solution
        dp = [0]*(amount+1)
        dp[0] = 1
        
        for coin in coins:
            for j in range(1, amount+1):
                if j >= coin:
                    dp[j] += dp[j-coin]
                    
        return dp[-1]
    
    
"""   
    # 2-d list solution
    def change(self, amount, coins):
        # edge case
        if coins == None or len(coins) == 0:
            return 0
        
        rows = len(coins) + 1
        cols = amount + 1
        dp = [[0]*cols for i in range(rows)]
        
        for i in range(rows):
            dp[i][0] = 1
        #dp[1] = [1,1,1,1,1,1]
        
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[-1][-1]
"""  
  
s = Solution()
print(s.change(5,[1,2,5]))