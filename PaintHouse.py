# Time Complexity : O(n) where n is the costs
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
def minCost(self, costs: List[List[int]]) -> int:
        size = len(costs)

        if size == 0:
            return 0

        if size == 1:
            return min(costs[0])

        for i in range(1,size):
            # Red: Add min of Green and Blue
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            # Green: Add min of Red and Blue
            costs[i][1] += min(costs[i -  1][0], costs[i - 1][2])
            # Blue: Add min of Red and Green
            costs[i][2] += min(costs[i - 1][1], costs[i - 1][0])

        return min(costs[-1])
