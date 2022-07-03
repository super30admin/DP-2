#time complexity: O(n), since colmns are constant:3
#space complexity:O(1), mutating original matrix
#approach: add the present cost to minimum of below row's other colmns cost.
#start from last but one row
# pick the minimum from top row after adding the min costs.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        for i in range(n-2, -1, -1):
            costs[i][0]=costs[i][0]+(min(costs[i+1][1], costs[i+1][2]))
            costs[i][1]=costs[i][1]+(min(costs[i+1][0], costs[i+1][2]))
            costs[i][2]=costs[i][2]+(min(costs[i+1][1], costs[i+1][0]))
        return min(costs[0][0], costs[0][1], costs[0][2])
                                                              
                                     
        