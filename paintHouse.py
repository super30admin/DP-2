#Time Complexity: O(n) where n is the number of houses
#Space Complexity: O(n)
#Did it run on leetcode: yes

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        rows = len(costs)
        columns = len(costs[0])
        dp = [[[] for jindex in range(columns)] for row in range(rows)]
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]
        for index in range(1, rows):
                    dp[index][0] = min(dp[index-1][1] + costs[index][0], dp[index-1][2] + costs[index][0])
                    dp[index][1] = min(dp[index-1][0] + costs[index][1], dp[index-1][2]+ costs[index][1])
                    dp[index][2] = min(dp[index-1][0]+ costs[index][2], dp[index-1][1]+ costs[index][2])
        return min(dp[rows-1][0],dp[rows-1][1],dp[rows-1][2])