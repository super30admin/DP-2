# Time Complexity O(n*3) ~= O(n)
import sys
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        minimum = sys.maxint
        if not costs:
            return 0
        else:
            for i in range(1,len(costs)):
                for j in range(len(costs[0])):
                    if j !=0 and j!= len(costs[0])-1:
                        costs[i][j] = min(costs[i-1][j-1], costs[i-1][j+1]) + costs[i][j]
                    elif j == 0:
                        costs[i][j] = min(costs[i-1][j+1],costs[i-1][j+2]) + costs[i][j]
                    else:
                         costs[i][j] = min(costs[i-1][j-1],costs[i-1][j-2]) + costs[i][j]
            return min(costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][2])
