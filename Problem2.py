# Time complexity: O(n)
# Space complexity: O(1)

#Leetcode premium

#Approach
#Start from 1th row in costs table
# Calculate minimum at each column (color) by taking minimum of the other two colors for previous row
# Follow the same for each row
# Final answer will be minimum value in the final row

#Iterative tabular DP
def minCost(costs):
    n = len(costs)
    if n == 0:
        return 0

    for i in range(1, n):
        for j in range(3):
            costs[i][j] = costs[i][j] + min(costs[i-1][(j+1)%3], costs[i-1][(j+2)%3])
    
    return min(costs[n-1][0], costs[n-1][1], costs[n-1][2])


#TC
#[[17, 2, 17]
# [16, 16, 5],
# [14, 3, 19]]

# n = 3

# i = 1, j = 0, costs[1][0] = 16 + min(costs[0][1], costs[0][2]) = 16 + 2 = 18
# i = 1, j = 1, costs[1][1] = 16 + min(costs[0][2], costs[0][0]) = 16 + 17 = 33
# i = 1, j = 2, costs[1][2] = 5 + min(costs[0][0], costs[0][1]) = 5 + 2 = 7

# i = 2, j = 0, costs[2][0] = 14 + min(costs[1][1], costs[1][2]) = 14 + 7 = 21
# i = 2, j = 1, costs[2][1] = 3 + min(costs[1][2], costs[1][0]) = 3 + 7 = 10
# i = 2, j = 2, costs[2][2] = 19 + min(costs[1][0], costs[1][1]) = 19 + 18 = 37


#[[17, 2, 17]
# [16+2, 16+17, 5+2],
# [14+7, 3+7, 19+18]]

#


def main():
    costs = [[17,2,17],[16,16,5],[14,3,19]]
    print(minCost(costs))

main()





#Recursive solution

# def minCost(costs, index, colorIndex):
#     if index == len(costs):
#         return 0

#     if colorIndex == 0:
#         return min(minCost(costs, index - 1, 1) + costs[index][0], minCost(costs, index - 1, 2) + costs[index][0])
#     if colorIndex == 1:
#         return min(minCost(costs, index - 1, 2) + costs[index][1], minCost(costs, index - 1, 0) + costs[index][1])
#     if colorIndex == 2:
#         return min(minCost(costs, index - 1, 0) + costs[index][2], minCost(costs, index - 1, 1) + costs[index][2])