# Time Complexity : O(n)
# Space Complexity : O(1)
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def minCost(self, costs: List[List[int]]):
        n = len(costs)
        costR = costs[n-1][0]
        costB = costs[n-1][1]
        costG = costs[n-1][2]

        for i in range(n-2, -1, -1):
            tempR = costR
            costR = costs[i][0] + min(costB, costG)
            tempB = costB
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)
        
        return min(costG, costB, costR)

sc = Solution()
costs = [[17,2,17],[16,16,5],[14,3,19]]
print(sc.minCost(costs))