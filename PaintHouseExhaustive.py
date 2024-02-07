'''
TC: O(2^n) where n is the number of houses
SC: O(m) - height of the tree
'''
from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:        

        def helper(idx, color, costTillNow):
            #base
            if idx>=len(costs):
                return costTillNow


            #logic
            if color == 0:
                return min(helper(idx+1, 1, costTillNow+costs[idx][0]),
                helper(idx+1, 2, costTillNow+costs[idx][0]))
            if color == 1:
                return min(helper(idx+1, 0, costTillNow+costs[idx][1]),
                helper(idx+1, 2, costTillNow+costs[idx][1]))
            if color == 2:
                return min(helper(idx+1, 0, costTillNow+costs[idx][2]),
                helper(idx+1, 1, costTillNow+costs[idx][2]))

        costR = helper(0, 0, 0)
        costB = helper(0, 1, 0)
        costG = helper(0, 2, 0)

        return min(costR, costB, costG)
s = Solution()
print(s.minCost([[17,2,17],[16,16,5],[14,3,19]]))
print(s.minCost([[7,6,2]]))
'''print(s.minCost([[5,6,5],[15,8,8],[13,19,7],[16,1,9],[15,2,18],
                 [13,18,8],[4,1,3],[3,3,3],[16,14,14],[7,6,1],
                 [7,17,17],[8,20,10],[12,16,1],[8,11,8],[14,7,12],
                 [8,18,13],[6,2,3],[16,1,11],[4,2,10],[17,16,17],
                 [1,8,17],[1,12,17],[1,11,10]])) 
                 Time Limit exceeded as expected'''