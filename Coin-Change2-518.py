# Time Complexity : O(nm)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0 for _ in range(amount + 1)]
        
        dp[0] = 1
        
        for coin in coins:
            for current_amount in range(1, (amount + 1)):
                if coin <= current_amount:

                    dp[current_amount] +=  dp[current_amount - coin]
        return dp[-1]