#
# Time complexity O(9n) = O(n)
# Space complexity O(1)
# Works on leetcode
#
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        index = 1
        if len(costs) == 0:
            return 0
        for i in range(len(costs)-2, -1, -1):
            for j in range(3):
                minc = float("inf")
                for k in range(3):
                    if costs[i+1][k] < minc and k != j:
                        minc = costs[i+1][k]
                costs[i][j] += minc
        return min(costs[0])
