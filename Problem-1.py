"""
create the decision tree for each color. make decisions at each node and pick the path that leads to the min amount in
total.

For bottom up, start with the last row and choose the min of available options in each row going up.

"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # Approach 1: Top down
        """
        red = self.helper(costs, 0, 0, 0)
        blue = self.helper(costs, 0, 1, 0)
        green = self.helper(costs, 0, 2, 0)
        return min(red, blue, green)

    def helper(self, costs, row, color, total_cost):
        #base
        if row >= len(costs):
            return total_cost

        #red
        if color == 0:
            return min (\
                        self.helper(costs, row + 1, 1, total_cost + costs[row][color]),\
                        self.helper(costs, row + 1, 2, total_cost + costs[row][color])
            )


        #blue
        if color == 1:
            return min (\
                        self.helper(costs, row + 1, 0, total_cost + costs[row][color]),\
                        self.helper(costs, row + 1, 2, total_cost + costs[row][color])
            )


        #green
        if color == 2:
            return min (\
                        self.helper(costs, row + 1, 0, total_cost + costs[row][color]),\
                        self.helper(costs, row + 1, 1, total_cost + costs[row][color])
            )

        """
        # Approach 2: Bottom up
        dp = [[0] * 3 for _ in costs]
        dp[-1] = costs[-1]

        for i in range(len(costs) - 2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][2], dp[i + 1][0])
            dp[i][2] = costs[i][2] + min(dp[i + 1][1], dp[i + 1][0])
        return min(dp[0])


"""
Approach 1:
TC: O(2^n)
SC: O(n)
Approach 2:
TC: O(n)
SC: O(n)
"""