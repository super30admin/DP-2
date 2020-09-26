"""
Problem: Find the minimum cost to paint all houses with colors red, green, blue of different costs.
Leetcode: https://leetcode.com/problems/paint-house/
Example:
    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
Solution: Brute force with a Recursive Tree.
Time Complexity: O(2^n), where n is the number of houses, each permutation adds 2 nodes to the tree
Space Complexity: O(n), because of the space usage on the run-time stack
"""


class Solution:
    def min_cost(self, costs):
        if costs is []:
            return 0

        def paint_cost(n, color):
            total_cost = costs[n][color]
            # if n is the last house number
            if n == len(costs)-1:
                pass
            # regular cases
            elif color == 0: #Red
                total_cost += min(paint_cost(n + 1, 1), paint_cost(n + 1, 2))
            elif color == 1: #Blue
                total_cost += min(paint_cost(n + 1, 0),paint_cost(n + 1, 2))
            elif color == 2: #Green
                total_cost += min(paint_cost(n + 1,0), paint_cost(n + 1, 1))

            return total_cost

        return min(paint_cost(0, 0), paint_cost(0, 1), paint_cost(0, 2))


obj = Solution()
print(obj.min_cost([[17,2,17],[16,16,5],[14,3,19]]))