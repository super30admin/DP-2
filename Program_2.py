"""
Time Complexity : Inside function
Space Complexity : Inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach

Problem_1:  Coin Change 2, You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
            Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
            You may assume that you have an infinite number of each kind of coin.
            The answer is guaranteed to fit into a signed 32-bit integer.
"""

# Approach - 1
class Solution:
     
    def change(self, amount: int, coins: List[int]) -> int:
        """
        Time Complexity : O(2^n)
        Space Complexity : O(n)
        """
        #edge case
        if amount == 0 or len(coins) == 0: return 0
        return self.change_helper(amount, coins, 0)
        
    def change_helper(self, amount, coins, index):
        #base case
        if amount == 0:
            return 1
        
        if amount < 0 or index == len(coins):
            return 0
        
        
        #logic
        #if choosing the coin
        case_1 = self.change_helper(amount - coins[index], coins, index)
        
        #if not choosing the coin
        case_2 = self.change_helper(amount, coins, index + 1)
        
        return case_1 + case_2

# Approach - 2

class Solution_3:
     
    def change(self, amount, coins) -> int:
        """
        Time Complexity : O(n *m) n is the amount and m is the num of coins
        Space Complexity : O(n *m)
        """
        if coins == [] or len(coins) == 0: return 0
        
        m, n= len(coins), amount
        dp = [[0 for i in range(n + 1)]  for j in range(m + 1)]
        
        dp[0][0] = 1
        
        for i in range(1, len(dp)):
            for j in range(0, len(dp[0])):
                #for the amount smaller than the denomination
                
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                    
                    
        return dp[m][n]

# Approach - 3
class Solution_3:
     
    def change(self, amount, coins) -> int:
        """
        Time Complexity : O(n) n is the amount and m is the num of coins
        Space Complexity : O(n)
        """
        if coins ==[] or len(coins) == 0: return 0
        
        arr = [0 for i in range(amount +1)] 
        arr[0] = 1
        for x in coins:
            for y in range(0, amount + 1):
                if y < x:
                    arr[y] = arr[y]
                else:
                    arr[y] = arr[y] + arr[y - x]
                    
        return arr[amount]