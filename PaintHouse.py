# # Approach1: Top-Down Recursive (Brute Force without Memoization)
# # Recursively tries all valid combinations.
# # No memoization: Recomputes the same subproblems many times → inefficient.
# # Starts with all 3 color choices at the first house and explores all paths.
# # Time Complexity: Exponential → O(2^n)
# # Space Complexity: O(n) due to recursive stack depth.

# class Solution:
#     def min_cost(self, costs: List[List[int]]) -> int:
#     # Helper function to recursively compute the minimum cost
#     # costs: 2D list of painting costs
#     # total: current accumulated cost
#     # row: current house index
#     # lastColor: color used for the previous house (0 = red, 1 = blue, 2 = green)
#         def helper(costs, total, row, lastColor):
#             # Base case: all houses have been painted
#             if row == len(costs):
#                 return total
#             # Initialize all cases with infinity (we'll overwrite valid ones)
#             case1 = case2 = case3 = float('inf')
#             # Try painting current house red if previous was not red
#             if lastColor != 0:
#                 case1 = helper(costs, total + costs[row][0], row + 1, 0)
#             # Try painting current house blue if previous was not blue
#             if lastColor != 1:
#                 case2 = helper(costs, total + costs[row][1], row + 1, 1)
#             # Try painting current house green if previous was not green
#             if lastColor != 2:
#                 case3 = helper(costs, total + costs[row][2], row + 1, 2)
#             # Return the minimum cost from all valid choices
#             return min(case1, case2, case3)
#         # Try starting with each possible color for the first house
#         return min(helper(costs, 0, 0, 0),
#                 helper(costs, 0, 0, 1),
#                 helper(costs, 0, 0, 2))


# Approach2: Bottom-Up Dynamic Programming (In-Place Update)
# Iteratively builds up the result from the bottom.
# In-place modification: Updates the input costs matrix directly.
# Efficient: Avoids recomputation by solving subproblems first.
# Time Complexity: O(n)
# Space Complexity: O(1) (since it modifies costs in-place).

class Solution:
    def PaintHouse1(self, costs): # DP with 3xN matrix
        # Using a 2D array with 3 rows (colors) and n columns (houses)
        # Each cell represents the min cost to paint house `i` with color `j`
        paintCosts = [[0 for _ in range(len(costs))] for _ in range(3)]

        # Initialize the cost of painting the first house with each color
        paintCosts[0][0] = costs[0][0]  # red
        paintCosts[1][0] = costs[0][1]  # blue
        paintCosts[2][0] = costs[0][2]  # green

        # Fill the DP table for remaining houses
        for i in range(1, len(costs)):
            # Cost of painting house i red = red cost + min(blue, green of previous house)
            paintCosts[0][i] = costs[i][0] + min(paintCosts[1][i - 1], paintCosts[2][i - 1])
            # Cost of painting house i blue
            paintCosts[1][i] = costs[i][1] + min(paintCosts[0][i - 1], paintCosts[2][i - 1])
            # Cost of painting house i green
            paintCosts[2][i] = costs[i][2] + min(paintCosts[0][i - 1], paintCosts[1][i - 1])

        # Return the minimum cost to paint all houses
        return min(paintCosts[0][-1], paintCosts[1][-1], paintCosts[2][-1])

    def PaintHouse2(self, costs): # DP with Nx3 matrix
        # Using a 2D array with dimensions (houses x colors)
        # Each cell represents the cost to paint house i with a given color
        paintCosts = [[0 for _ in range(3)] for _ in range(len(costs))]

        # Initialize first house's paint costs
        paintCosts[0] = costs[0][:]

        # Build up the DP table row by row
        for i in range(1, len(costs)):
            # For each color, add the cost of current color with min of previous two other colors
            paintCosts[i][0] = costs[i][0] + min(paintCosts[i - 1][1], paintCosts[i - 1][2])  # red
            paintCosts[i][1] = costs[i][1] + min(paintCosts[i - 1][0], paintCosts[i - 1][2])  # blue
            paintCosts[i][2] = costs[i][2] + min(paintCosts[i - 1][0], paintCosts[i - 1][1])  # green

        # Return the minimum cost of painting all houses
        return min(paintCosts[-1])

    def PaintHouse3(self, costs): # Optimized space with 1D array
        # Optimize space using a 1D array of size 3 (since only previous row is needed)
        single_arr = costs[0][:]  # Initialize with first house's costs

        for i in range(1, len(costs)):
            # Save previous values before overwriting
            temp1, temp2 = single_arr[0], single_arr[1]

            # Update costs for current house
            single_arr[0] = costs[i][0] + min(temp2, single_arr[2])  # red
            single_arr[1] = costs[i][1] + min(temp1, single_arr[2])  # blue
            single_arr[2] = costs[i][2] + min(temp1, temp2)          # green

        # Return minimum cost to paint all houses
        return min(single_arr)

    def PaintHouse4(self, costs): # In-place update
        # In-place update of the input costs array to save space
        if len(costs) == 1:
            return min(costs[0])  # Only one house

        for i in range(1, len(costs)):
            # Update current house's costs by adding min cost of other two colors from previous house
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])  # red
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])  # blue
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])  # green

        # Return the minimum cost to paint all houses
        return min(costs[-1])
