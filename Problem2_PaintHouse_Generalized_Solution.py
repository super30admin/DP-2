'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 265. Paint House- II

# There are a row of n houses, each house can be painted with one of the k colors. 
# The cost of painting each house with a certain 
# color is different. You have to paint all the houses such that no two 
# adjacent houses have the same color.

# The cost of painting each house with a certain color is represented by an 
# n x 3 cost matrix costs.

# For example, costs[0][0] is the cost of painting house 0 with the color red; 
# costs[1][2] is the cost of painting house 1 with color green, and so on...

# Return the minimum cost to paint all houses.

# Example 1:

# Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
# Output: 10
# Explanation: Paint house 0 into blue, paint house 1 into green, 
# paint house 2 into blue.
# Minimum cost: 2 + 5 + 3 = 10.

# Example 2:

# Input: costs = [[7,6,2]]
# Output: 2

# Constraints:

# costs.length == n
# costs[i].length == 3
# 1 <= n <= 100
# 1 <= costs[i][j] <= 20

#-----------------
# Time Complexity: 
#-----------------
# O(NK^2): Need to iterate over input matrix once. If number of colors 
#       K is not a constant, then this would be O(N*K^2)
#       Because we need to traverse N*K elements and need an additional
#       nested K operation within that to find min of next row

#------------------
# Space Complexity: 
#------------------
# O(1) - Need only the input cost matrix

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  148 ms (43.43 %ile)
# Space            :  14.3 MB (60.86 %ile)


from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        INT_MAX = 21 # Constraint says max cost is 20
        num_houses = len(costs)
        num_colors = len(costs[0])

        if (num_houses == 0 or num_colors == 0 ):
            return -1

        # O(N)
        for i in range(num_houses-2,-1,-1):
            # print(f"i:{i}")
            # O(K)
            for j in range(num_colors):
                # print(f"j:{j}")

                # O(K) operation
                costs[i][j] += min( [cost for (index, cost) in\
                                     enumerate(costs[i+1]) if index != j])

                # if j == 0:

                #     # Finding min with 2 numbers is O(K) where K
                #     # is the num of colors
                #     costs[i][j] += min(costs[i+1][j+1], \
                #                             costs[i+1][j+2])
                # elif j == 1:
                #     costs[i][j] += min(costs[i+1][j-1], \
                #                             costs[i+1][j+1])
                # elif j == 2:
                #     costs[i][j] += min(costs[i+1][j-1], \
                #                             costs[i+1][j-2])

                # print(f"costs[{i}][{j}]:{costs[i][j]}")

        return min(costs[0])

obj = Solution()

print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))




