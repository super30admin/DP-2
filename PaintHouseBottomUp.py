'''
TC: O(m) where m is the number of costs given
SC: O(n) is number of colors res array
'''
from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:        
        res = [0]*len(costs[0])
        for i in range(len(costs)-1,-1,-1):
            costs[i][0] = costs[i][0]+min(res[1], res[2])
            costs[i][1] = costs[i][1]+min(res[0], res[2])
            costs[i][2] = costs[i][2]+min(res[0], res[1])
            res = costs[i]
        return min(res)
s = Solution()
print(s.minCost([[17,2,17],[16,16,5],[14,3,19]]))
print(s.minCost([[7,6,2]]))
print(s.minCost([[5,6,5],[15,8,8],[13,19,7],[16,1,9],[15,2,18],
                 [13,18,8],[4,1,3],[3,3,3],[16,14,14],[7,6,1],
                 [7,17,17],[8,20,10],[12,16,1],[8,11,8],[14,7,12],
                 [8,18,13],[6,2,3],[16,1,11],[4,2,10],[17,16,17],
                 [1,8,17],[1,12,17],[1,11,10]])) 