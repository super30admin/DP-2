# Time Complexity: O(N), N is the number of elements in costs list
# Space Complexity: O(1), we are using only 1D array of size 3
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        rows = len(costs)
        columns = 3
        dp = [None] * columns
        
        for col in range(columns):
            dp[col] = costs[rows - 1][col]
        
        for row in range(rows - 2, -1, -1):
            temp_0 = dp[0]
            dp[0] = costs[row][0] + min(dp[1], dp[2])
            temp_1 = dp[1]
            dp[1] = costs[row][1] + min(temp_0, dp[2])
            dp[2] = costs[row][2] + min(temp_0, temp_1)
        
        return min(dp)
