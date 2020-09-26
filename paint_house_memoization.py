"""
Problem: Find the minimum cost to paint all houses with colors red, green, blue of different costs.
Leetcode: https://leetcode.com/problems/paint-house/
Example:
    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
Solution: Memoization with recursion
Time Complexity: O(n), where n is the number of houses
Space Complexity: O(n), because of the space usage on the run-time stack
"""


class Solution:
    def min_cost(self, costs):

        def paint_cost(n, color):
            if (n, color) in self.memo:
                return self.memo[(n,color)]

            total_cost = costs[n][color]

            # if n is the last house number
            if n == len(costs) - 1:
                pass
            elif color == 0:
                total_cost += min(paint_cost(n+1, 1), paint_cost(n+1, 2))
            elif color == 1:
                total_cost += min(paint_cost(n+1, 0), paint_cost(n+1, 2))
            elif color == 2:
                total_cost += min(paint_cost(n+1, 0), paint_cost(n+1, 1))

            self.memo[(n,color)] = total_cost
            return total_cost

        if costs is []:
            return 0

        # Define a hashmap
        self.memo = {}
        return min(paint_cost(0, 0), paint_cost(0, 1), paint_cost(0, 2))


obj = Solution()
print(obj.min_cost([[17,2,17],[16,16,5],[14,3,19]]))