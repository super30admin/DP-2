# problem 1 : 256. Paint House : https://leetcode.com/problems/paint-house/
# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        cost = costs[0]
        house = len(costs)
        if house == 1:
            return min(cost)
        for i in range(1,house):
            cost[0], cost[1], cost[2] = (costs[i][0] + min(cost[1],cost[2])), (costs[i][1] + min(cost[0],cost[2])), (costs[i][2] + min(cost[0],cost[1]))
        return min(cost)


# problem 2 : 518. Coin Change 2 : https://leetcode.com/problems/coin-change-2/
# Time Complexity : O(N * S) N is amount and S is number of coins 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

 class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] += dp[x - coin]
        return dp[amount]        
