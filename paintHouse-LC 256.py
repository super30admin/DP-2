# Time Complexity = O(n * 3) = O(n)
# Space Complexity = O(1), since we are modifying the original array and not making a new one


class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        
        n = len(costs)
            
        for i in range(n - 2, -1, -1):
            
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][1], costs[i + 1][0])
            
        return min(costs[0][0], min(costs[0][1], costs[0][2]))