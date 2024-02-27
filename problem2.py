# Time Complexity : O(n * m), where n is the amount and m is the number of coins. 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes

from ast import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0] * (amount + 1)
        dp[0] = 1  
        
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]  
            
        return dp[amount]

        