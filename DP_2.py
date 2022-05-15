# Time Complexity : O(3n) -> O(n) | n -> Number of Houses
# Space Complexity : O(3n) -> O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# https://leetcode.com/problems/paint-house/
import math
class Solution:

    def helper(self, costs, house_idx, color_idx, dp):
        if color_idx == 0:
            dp[house_idx][color_idx] = min(dp[house_idx-1][1], dp[house_idx-1][2]) + costs[house_idx][color_idx]
        elif color_idx == 1:
            dp[house_idx][color_idx] = min(dp[house_idx-1][0], dp[house_idx-1][2]) + costs[house_idx][color_idx]
        elif color_idx == 2:
            dp[house_idx][color_idx] = min(dp[house_idx-1][0], dp[house_idx-1][1]) + costs[house_idx][color_idx]
    
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [[0]*len(costs[0]) for i in range(len(costs))]
        dp[0] = costs[0]
        
        for i in range(1,len(costs)):
            for j in range(len(costs[0])):
                self.helper(costs, i, j, dp)
                
        return min(dp[-1])

# Time Complexity : O(2^n) | n -> number of houses
# Space Complexity : O(2^n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# https://leetcode.com/problems/coin-change-2/

class Solution:
    
    def helper(self, amt, coin_idx, coins):
        
        if amt == 0:
            return 1
        elif amt < 0 or coin_idx >= len(coins):
            return 0
        
        case1 = self.helper(amt, coin_idx+1, coins)
        case2 = self.helper(amt-coins[coin_idx], coin_idx, coins)
        
        return case1 + case2
    
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins: return 0     
        
        return self.helper(amount, 0, coins)

            