class Solution(object):
    def __helper(self, costs, index, houseNumber, minCost):
        if houseNumber >= len(costs):
            return minCost
        if 0 in index:
            redCost = self.__helper(costs, [1,2], houseNumber + 1, minCost+costs[houseNumber][0])
        else:
            redCost = float('inf')
        if 1 in index:
            blueCost = self.__helper(costs, [0,2], houseNumber + 1, minCost+costs[houseNumber][1])
        else:
            blueCost = float('inf')
        if 2 in index:
            greenCost = self.__helper(costs, [0,1], houseNumber + 1, minCost+costs[houseNumber][2])
        else:
            greenCost = float('inf')
        return min(redCost, blueCost, greenCost)
        
        
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        return self.__helper(costs, [0,1,2], 0, 0)


class Solution2(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0 or costs == []:
            return 0
        rows = len(costs)
        cols = len(costs[0])
        dp = [[None for i in range(cols)] for j in range(rows)]
        for i in range(cols):
            dp[0][i] = costs[0][i]
        for i in range(1, rows):
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]
        return min(dp[rows-1])


costs = [[17,2,17],[16,16,5],[14,3,19]]
obj1 = Solution()
obj2 = Solution2()
print(obj1.minCost(costs))
print(obj2.minCost(costs))