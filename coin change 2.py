# // Time Complexity : O(amount* coins)
# // Space Complexity : O(amount)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0] * (amount + 1)
        
        # base case
        dp[0] = 1
        
        # loop over all coins
        for coin in coins:
            
            # loop over to all amounts from 0 to amount for each coin
            for x in range(coin, amount + 1):
                
                # recurrence relation for number of combinations
                dp[x] += dp[x - coin] 
        
        return dp[amount]