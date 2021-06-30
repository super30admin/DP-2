-------------------------Brute Force Solution --------------------------------------------

# Time Complexity : O(pow(2,n*k)) n is the length of coins  array and k is the amount
# Space Complexity : O(pow(2,n*k)) as recursion will create stack at each iteration
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here In the brute force solution I have used a recursion technique where I have chose
# 2 paths when we consider a coin and not consider a coin. When we consider a coin 
#we are reducing the amount by the coin and iterating again until we get the amount ==0 or less than 0.
# In the other choice I am just increasing the index and iterating again.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Edge Case
        if not amount and not coins:
            return 1
        elif not coins:
            return 0
        
        def dfs(coins, amount,index):
            if amount == 0:
                return 1
            
            if amount <0 or index == len(coins):
                return 0
            res = 0
            
            if coins[index]<=amount:
                res += dfs(coins, amount-coins[index], index)
        
            res += dfs(coins,amount, index+1)
            return res

        return dfs(coins, amount, 0)
        
        
--------------------------Optimized  Solution___________________        
# Time Complexity : O(nk) n is the length of coins  array and k is the amount
# Space Complexity : O(nk) as recursion will create stack at each iteration
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here In the optimized solution I have used a dynamic programming technique where I have chose
# 2 paths , the 0th case is from the result obtained from previous result.
# We are adding the number of ways we can represent the amount from previous result.    

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount+1)
        dp[0] = 1
        
        for coin in coins:
            for j in range(coin,len(dp)):
                dp[j] += dp[j-coin]
        return dp[-1]