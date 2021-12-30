'''Recursion without Memo Complexity'''

# Time Complexity : C ^ (A) where C is number of coins and A is the amount (Using for loop pattern)
# Space Complexity : O(A) for recursion stack
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

'''Recursion with Memo'''
# Time Complexity : There are A * C combinations that get evaluated and cached. Hence, O(A * C)
# Space Complexity : O(A * C) for the cache
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        def recur(target, start, memo):
            
            if target < 0:
                return 0
            
            if target == 0:
                return 1
            
            
            if (target, start) in memo:
                return memo[(target, start)]
            
            
            totalWays = 0
            for i in range(start, len(coins)):
                totalWays += recur(target - coins[i], i, memo)
            
            memo[(target, start)] = totalWays
            return memo[(target, start)]
        
        return recur(amount, 0, {})

# Time Complexity : O(A * C), A: Amount and C: Number of Coins
# Space Complexity : O(A)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]
        return dp[-1]