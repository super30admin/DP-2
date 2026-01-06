"""
time - o(n)
space o(n)
we take a look at the problem as only one row of houses, in this case we just take the minimum. The same problem space is increased
by adding another row of houses, we then for the second row have to look at each paint cost and add the min paint cost from the previous row
without the current paint id. Finally, at the last row we just return the min.
"""

from typing import List
import copy


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = copy.deepcopy(costs)
        for i in range(1, len(costs)):
            for j in range(len(costs[0])):
                if j == 0:
                    dp[i][j] += min(dp[i - 1][1], dp[i - 1][2])
                if j == 1:
                    dp[i][j] += min(dp[i - 1][0], dp[i - 1][2])
                if j == 2:
                    dp[i][j] += min(dp[i - 1][0], dp[i - 1][1])
        return min(dp[-1])


"""
recursive with memoization
time - o(n) without memo it is o(2^n) as we make a choice at every instance between two other paint costs but with memoization we only make
        x number of calculations and store the result. Here x is 3 * 2 * n where 3 is the paint choices, 2 is the number of choices we make
        at each node.
space o(n)

we start at the top row and make all three paint choices and call the helper function, helper function goes down the rows recursively
and carries the previous choice and index along with cost and dict as parameters. Once the paint cost is calculated (min of the other two paint choices based on previous selection) 
we store it based on previous selection and current index in the memo

"""


class Solution2:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 1:

            return min(costs[0])
        memo = {}
        cost = float("inf")
        for i in range(len(costs[0])):
            cost = min(cost, self.helper(costs, i, 1, costs[0][i], memo))
        return cost

    def helper(self, costs, prev_selection, index, curr_cost, memo):
        if (prev_selection, index) in memo:
            return memo[(prev_selection, index)]
        if index == len(costs):
            return curr_cost
        next_cost = float("inf")
        for i in range(len(costs[index])):
            if i != prev_selection:
                next_cost = min(
                    next_cost, self.helper(costs, i, index + 1, costs[index][i], memo)
                )
        total_cost = next_cost + curr_cost
        memo[(prev_selection, index)] = total_cost
        return total_cost
