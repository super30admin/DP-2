## Problem1(https://leetcode.com/problems/paint-house/)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        
        # Base case: Store the cost of painting the very last house.
        # Index 0 = Red, Index 1 = Blue, Index 2 = Green
        costR = costs[n - 1][0]
        costB = costs[n - 1][1]
        costG = costs[n - 1][2]

        # Iterate backwards starting from the second-to-last house down to the first house
        for i in range(n - 2, -1, -1):
            # Temporarily store the current accumulated Red cost 
            # so it's not overwritten before we use it to calculate Blue and Green
            tempR = costR 
            
            # The new Red cost is the cost to paint the current house Red PLUS
            # the minimum cost of painting the next house either Blue or Green.
            costR = costs[i][0] + min(costB, costG)
            
            # Temporarily store the current accumulated Blue cost
            tempB = costB
            
            # The new Blue cost is the cost to paint the current house Blue PLUS
            # the minimum cost of painting the next house either Red (using tempR) or Green.
            costB = costs[i][1] + min(tempR, costG)
            
            # The new Green cost is the cost to paint the current house Green PLUS
            # the minimum cost of painting the next house either Red (using tempR) or Blue (using tempB).
            costG = costs[i][2] + min(tempR, tempB)
        
        # Once we've reached the first house, the minimum of the three accumulated costs 
        # gives us the absolute minimum cost to paint all houses validly.
        return min(costR, costB, costG)
    

obj = Solution()
print('minCost:', obj.minCost([[3, 5, 6], [5, 6, 7], [8, 9, 3]]))