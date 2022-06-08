'''
Time Complexity : O(m) where m is number of houses
Space Complexity: O(1) In place modification
Run on LeetCode : YES
'''
class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
            size=len(costs)
            if size == 0: return 0
            if size == 1: return min(costs[0])
            for i in range(1,size):
                costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
                costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
                costs[i][2]+=min(costs[i-1][1],costs[i-1][0])
            return min(costs[size - 1])