# TC: O(len(costs))
# SC : O(len(costs))

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        n = len(costs)
        red = [0]*n
        green = [0]*n
        blue = [0]*n

        red[0] = costs[0][0]
        green[0] = costs[0][1]
        blue[0] = costs[0][2]

        for i in range(1, n):
            red[i] = min(green[i-1],blue[i-1]) + costs[i][0]
            green[i] = min(red[i-1],blue[i-1]) + costs[i][1]
            blue[i] = min(green[i-1],red[i-1]) + costs[i][2]

        return min(red[-1],green[-1],blue[-1])