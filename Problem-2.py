#  Paint House
'''
Leetcode all test cases passed: Yes
Solution:

    def change(self, amount, coins):
        n is the number of coins
        m is the amount
        Space Complexity: O(m)
        Time Complexity: O(n * m)
'''
class Solution:
    def change(self, amount, coins):
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        
        for coin in coins:
            idx = coin
            while idx < amount + 1:
                dp[idx] = dp[idx] + dp[idx - coin]  
                idx += 1
        return dp[-1]
