class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        :space complexity O(n*3)
        :time complexity O(n)
        """
    
        row, col = len(costs), len(costs[0])
        # Create 2D list to compute result
        dp = [[0 for _ in range(col)] for _ in range(row)]
        # first row would be same as provded cost array
        dp[0] = costs[0]
        for i in range(1, row):
            dp[i][0] = costs[i][0] + min(dp[i-1][1:3])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][:2])
        return min(dp[-1])
       
        