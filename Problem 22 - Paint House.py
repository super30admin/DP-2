# 256. Paint House

# Time complexiety: O(3*n)
# Space complexiety: O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        minCost = min(costs[0][0],costs[0][1],costs[0][2])

        for i in range(1,len(costs)):
            # RED
            costs[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2])
            # GREEN
            costs[i][1] = costs[i][1] + min(costs[i-1][0],costs[i-1][2])
            # BLUE
            costs[i][2] = costs[i][2] + min(costs[i-1][0],costs[i-1][1])

            minCost = min(costs[i][0],costs[i][1],costs[i][2])
        
        return minCost
