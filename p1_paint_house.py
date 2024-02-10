class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        length = len(costs)
        red = costs[length-1][0]
        green = costs[length-1][1]
        blue = costs[length-1][2]
        for i in range(len(costs)-2, -1, -1):
            temp_red = red
            temp_green = green
            temp_blue = blue
            red = costs[i][0] + min(temp_green, temp_blue)
            green = costs[i][1] + min(temp_red, temp_blue)
            blue = costs[i][2] + min(temp_red, temp_green)
        return min(red, min(green, blue))

# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         f_red = self.helper(0, 0, costs)
#         f_green = self.helper(1, 0, costs)
#         f_blue = self.helper(2, 0, costs)
#         return min(f_red, min(f_green, f_blue))

#     def helper(self, col, row, cost_matrix):
#         # Base 
#         if row == len(cost_matrix):
#             return 0
#         # Logic
#         # Current house: Red
#         if col == 0:
#             return cost_matrix[row][col] + \
#             min(self.helper(1, row+1, cost_matrix), 
#                 self.helper(2, row+1, cost_matrix))

#         # Current house: Green
#         elif col ==  1:
#             return cost_matrix[row][col] + \
#             min(self.helper(0, row+1, cost_matrix), 
#                 self.helper(2, row+1, cost_matrix))

#         # Current house: Blue
#         elif col == 2:
#             return cost_matrix[row][col] + \
#             min(self.helper(0, row+1, cost_matrix), 
#                 self.helper(1, row+1, cost_matrix))
