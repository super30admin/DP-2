#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this :
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0

        if len(costs) == 1: return min(costs[0])

        rows = len(costs)
        dp = costs

        for i_row in range(1, rows):  # starting from the second row
            for j_col in range(3):  # iterate through red, blue, green
                if j_col == 0:  # red
                    dp[i_row][j_col] += min(dp[i_row - 1][j_col + 1],
                                            dp[i_row - 1][j_col + 2])  # pick the min cost from (blue or green)

                if j_col == 1:  # blue
                    dp[i_row][j_col] += min(dp[i_row - 1][j_col - 1],
                                            dp[i_row - 1][j_col + 1])  # pick the min cost from (red or green)

                if j_col == 2:  # green
                    dp[i_row][j_col] += min(dp[i_row - 1][j_col - 2],
                                            dp[i_row - 1][j_col - 1])  # pick the min cost from (red or blue)

        return min(dp[-1])  # last row will have the 3 cumulative cost of 3 houses based on min cost. return mininum
