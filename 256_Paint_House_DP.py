# Time Complexity : O(n * k) [n = number of houses, k = number of colors]
# 
# Space Complexity : O(1) [inpur array is used to save the min cost result]
# 
# Did this code successfully run on Leetcode : Partially(TLE)
# 
# Any problem you faced while coding this : No
#
# Problem Approach:
# 1. Start with house 1. 
# 	1.1 If color 0 is used to color the house 1. Then we will color the house 0 with minimum of color 1 and color 2
#	1.2 If color 1 is used to color the house 1. Then we will color the house 0 with minimum of color 0 and color 2
# 	1.3 If color 2 is used to color the house 1. Then we will color the house 0 with minimum of color 0 and color 1.
# 2. The same approach is followed for subsequent houses   
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:return 0
        for i in range(1,len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][1], costs[i-1][0])
        return min(costs[-1])