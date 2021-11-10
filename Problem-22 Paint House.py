# 256. Paint House
# https://leetcode.com/problems/paint-house/


# Brute Force
# Time complexiety: O(3*2^n)
# Space complexiety: O(n)

class Solution:
    def _helper(self, costs, idx, currColor):
        if idx == len(costs):
            return 0

        # Red
        if currColor == 0:
            green = self._helper(costs, idx+1, 1)
            blue = self._helper(costs, idx+1, 2)
            return costs[idx][0]+min(blue, green)
        
        # Green
        if currColor == 1:
            red = self._helper(costs, idx+1, 0)
            blue = self._helper(costs, idx+1, 2)
            return costs[idx][1]+min(blue, red)
        
        # Blue
        if currColor == 2:
            red = self._helper(costs, idx+1, 0)
            green = self._helper(costs, idx+1, 1)
            return costs[idx][2]+min(red, green)

    def minCost(self, costs) -> int:
        # R G B
        # 0 1 2
        return min([self._helper(costs,0,0),self._helper(costs,0,1),self._helper(costs,0,2)])

obj = Solution()
# print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))


# DP
# Time complexiety: O(3*n)
# Space complexiety: O(1)

class Solution:
    def minCost(self, costs) -> int:
        # R G B
        # 0 1 2

        # DP Table
        #   R G B
        # 0
        # 1
        # 2

        minCost = min(costs[0][0],costs[0][1],costs[0][2])

        for i in range(1,len(costs)):
            # RED
            costs[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2])
            # GREEN
            costs[i][1] = costs[i][1] + min(costs[i-1][0],costs[i-1][2])
            # BLUE
            costs[i][2] = costs[i][2] + min(costs[i-1][0],costs[i-1][1])

            minCost = min(costs[i][0],costs[i][1],costs[i][2])
        
        return minCost

obj = Solution()
print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))