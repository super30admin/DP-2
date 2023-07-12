# Time: O(3n) i.e O(n)
# Space: O(1),using 6 spaces

# Bottom-up(tabulation) starting from nth house moving backwards with space optimisation
# at house j, if ith color is chosen then the min cost of coloring the j+1th house among other n-i colors plus cost[j][i] is its cost
# costs of coloring the house with each color as starting is computed and min among them is the min cost to color n-j houses

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        cost = costs[-1] #O(1)
        for i in range(len(costs)-2, -1, -1):
            current = costs[i].copy()
            #case0
            current[0] += min(cost[1], cost[2]) 
            #case1
            current[1] += min(cost[0], cost[2])
            #case2
            current[2] += min(cost[0], cost[1])
            cost = current
        return min(cost)