
from __future__ import annotations
import copy
import random
from typing import List



# =============================================================================
# Approach 1: Recursion
# =============================================================================
# Approach:
#   helper(costs, idx, color) returns the minimum cost to paint houses idx..end
#   given that house idx is painted with `color`. That cost is the price of the
#   color for this house plus the cheaper of the two other colors for the next
#   house. We try all three colors for the first house and take the minimum.
#   The base case is running past the last house, which costs 0.
#
# Time Complexity : O(3 * 2^n) - n = number of houses; 3 starting colors, then
#                   each call branches into 2 recursive calls per house
# Space Complexity : O(n) - recursion stack depth (one frame per house)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded on larger
#                   inputs (overlapping subproblems; needs memoization on
#                   (idx, color))
# Any problem you faced while coding this : Same (idx, color) subproblems are
#                   recomputed again and again
class SolutionRecursive:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        costs_red = self.helper(costs, 0, 0)
        costs_blue =  self.helper(costs, 0, 1)
        costs_green = self.helper(costs, 0, 2)
        return min(costs_red, min(costs_blue, costs_green))

    def helper(self,costs, idx, color):
        # base case
        if idx >= len(costs):
            return 0
        # logic
        if color == 0:
            return costs[idx][color] + min(self.helper(costs, idx+1, 1), self.helper(costs,idx+1,2))
        if color == 1:
            return costs[idx][color] + min(self.helper(costs,idx+1, 2), self.helper(costs,idx+1, 0))
        if color == 2:
            return costs[idx][color] + min(self.helper(costs,idx+1,0), self.helper(costs,idx+1,1))
        return 0


# =============================================================================
# Approach 2: DP (bottom-up, mutates the input matrix)
# =============================================================================
# Approach:
#   Work from the second-to-last house up to the first. For each house and color,
#   add the cheaper of the two other colors from the house right after it, so
#   costs[i][c] becomes the minimum cost to paint houses i..end when house i uses
#   color c. The last row is already correct as it is. The answer is the minimum
#   of the first row. This reuses the input matrix as the DP table, so no extra
#   space is needed, but the input gets modified.
#
# Time Complexity : O(n) - n = number of houses; 3 colors is a constant, so this
#                   is O(3 * n), also written O(M * N) with M = 3
# Space Complexity : O(1) - no extra space, the input matrix is mutated
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Mutating the input is a side effect
#                   the caller may not expect (see approach 3)
class SolutionDPMutating:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
        return min(costs[0][0], min(costs[0][1], costs[0][2]))


# =============================================================================
# Approach 3: DP (bottom-up, no mutation, three variables)
# =============================================================================
# Approach:
#   Same bottom-up idea, but instead of overwriting the matrix we only keep three
#   running values: the minimum cost to paint the houses after the current one
#   if the next house is red, blue, or green. Start from the last house, then
#   move up one house at a time. Each new value is this house's cost for that
#   color plus the cheaper of the other two colors from the previous step. The
#   old red and blue values are saved in temp variables before they are
#   overwritten, because the blue and green updates still need them. The answer
#   is the minimum of the three values after reaching the first house.
#
# Time Complexity : O(n) - n = number of houses, one pass with constant work
# Space Complexity : O(1) - only three variables plus two temps, input untouched
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Update order. costs_red changes first,
#                   so temp_red / temp_blue hold the old values for the next lines
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        costs_red = costs[len(costs)-1][0]
        costs_blue = costs[len(costs)-1][1]
        costs_green = costs[len(costs)-1][2]

        for i in range(len(costs) - 2, -1, -1):
            temp_red = costs_red
            temp_blue = costs_blue
            costs_red = costs[i][0] + min(costs_green, costs_blue)
            costs_blue = costs[i][1] + min(temp_red, costs_green)
            costs_green = costs[i][2] + min(temp_red, temp_blue)
        return min(costs_red, min(costs_green, costs_blue))


# =============================================================================
# Test cases
# =============================================================================
if __name__ == "__main__":
    # (costs, expected)
    tests = [
        ([[17, 2, 17], [16, 16, 5], [14, 3, 19]], 10),        # LeetCode example 1: blue, green, blue
        ([[7, 6, 2]], 2),                                      # LeetCode example 2: single house
        ([[1, 2, 3], [1, 2, 3]], 3),                           # two houses: 1 + 2 (can't repeat color 0)
        ([[5, 5, 5], [5, 5, 5], [5, 5, 5]], 15),               # all costs equal
        ([[1, 100, 100], [100, 1, 100], [100, 100, 1]], 3),    # diagonal is cheap
        ([[3, 5, 3], [6, 17, 6], [7, 13, 18], [9, 10, 18]], 26),  # 3 + 6 + 7 + 10
        ([[1, 1, 1], [1, 1, 1]], 2),                           # ties everywhere
        ([], 0),                                               # empty input guard
    ]

    solutions = [SolutionRecursive(), SolutionDPMutating(), Solution()]

    for sol in solutions:
        for costs, expected in tests:
            # deep copy because SolutionDPMutating modifies its input
            got = sol.minCost(copy.deepcopy(costs))
            assert got == expected, (
                f"{type(sol).__name__} failed: costs={costs}, "
                f"got={got}, expected={expected}"
            )
        print(f"{type(sol).__name__}: passed all {len(tests)} tests")

    # Check that the non-mutating DP really leaves the input untouched
    original = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
    snapshot = copy.deepcopy(original)
    Solution().minCost(original)
    assert original == snapshot, "Solution should not mutate its input"
    print("Solution: input left unchanged")

    # Cross-check: the three approaches must agree on random small inputs
    random.seed(0)
    for _ in range(200):
        n = random.randint(1, 8)
        costs = [[random.randint(1, 20) for _ in range(3)] for _ in range(n)]
        answers = {sol.minCost(copy.deepcopy(costs)) for sol in solutions}
        assert len(answers) == 1, f"approaches disagree on {costs}: {answers}"
    print("Random cross-check: all approaches agree on 200 inputs")

    # Large case: only the DP versions can handle it (recursion would hang).
    # Costs [1, 2, 3] on 100 houses: best is to alternate 1, 2, 1, 2, ...
    # which gives 50 * 1 + 50 * 2 = 150.
    large_costs = [[1, 2, 3] for _ in range(100)]
    for sol in solutions[1:]:
        got = sol.minCost(copy.deepcopy(large_costs))
        assert got == 150, f"{type(sol).__name__} failed large test: got={got}"
        print(f"{type(sol).__name__}: passed large test (100 houses)")