class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        
        n = len(costs)
        for i in range(n-2,-1,-1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1],costs[i+1][0])
        return min(costs[0][0],costs[0][1],costs[0][2])
    

#time complexity -- O(n)
#space complexity ---O(1) [as we are mutating the original array, we are not considering any extra space]