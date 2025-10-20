# EXHAUSTIVE SOLUTION

# Time: O(2^n) n=> number of houses
# Space: O(n) As the recursion depth is only till the length of costs i.e the number of rows which determines the houses

# Loop through the number of colors
# check in the helper function which color we use and use the remaining colors
# Check whats the cost of minimum between the two colors and add the current cost in it
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        min_val = float('inf')
        for n in range(len(costs[0])):
            min_val = min(min_val, self.helper(costs, 0, n))
        return min_val

    def helper(self, costs, idx, n):
        # base
        if idx == len(costs):
            return 0

        # Logic
        if n == 0:
            choose_blue = self.helper(costs, idx + 1, n + 1)
            choose_green = self.helper(costs, idx + 1, n + 2)

            return costs[idx][n] + min(choose_blue, choose_green)
        elif n == 1:
            choose_red = self.helper(costs, idx + 1, n - 1)
            choose_green = self.helper(costs, idx + 1, n + 1)

            return costs[idx][n] + min(choose_red, choose_green)
        else:
            choose_red = self.helper(costs, idx + 1, n - 2)
            choose_blue = self.helper(costs, idx + 1, n - 1)

            return costs[idx][n] + min(choose_red, choose_blue)
        


# MEMOISATION SOLUTION
# Time: O(3n) => which is O(n) because we have 3 colors and n number of houses
# Space: O(3n) => which is O(n) we crate a matrix of n * number of colors

# Just put everything in a memo matrix and use it to optimise on time

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        memo = [[-1 for _ in range(3)] for _ in range(len(costs))]
        for m in range(len(costs) -1, -1, -1 ):
                if m == len(costs) - 1:
                    memo[m][0] = costs[m][0]
                    memo[m][1] = costs[m][1]
                    memo[m][2] = costs[m][2]
                else:
                    memo[m][0] = costs[m][0] + min(memo[m+1][1], memo[m+1][2])
                    memo[m][1] = costs[m][1] + min(memo[m+1][0], memo[m+1][2])
                    memo[m][2] = costs[m][2] + min(memo[m+1][0], memo[m+1][1])

        return min(memo[0][0], memo[0][1],memo[0][2])