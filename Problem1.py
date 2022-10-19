#Time Complexity - O(n)
#Space Complexity - O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        for x in range(1, len(costs)):

            #Red
            costs[x][0] = costs[x][0] + min( costs[x - 1][1], costs[x - 1][2])
            
            #blue
            costs[x][1] = costs[x][1] + min( costs[x - 1][0], costs[x - 1][2])
            
            #green
            costs[x][2] = costs[x][2] + min( costs[x - 1][1], costs[x - 1][0])

        
        return min(costs[len(costs) - 1])