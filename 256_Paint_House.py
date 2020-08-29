# Leetcode problem link : https://leetcode.com/problems/paint-house
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : 1. O(2^n) => form a tree for each color for the first house and and the next two options for the second house and third house, so on and so forth. Once we have reached the last house or leaf nodes, we have the total cost for each permutation and we can choose the min cost path after exploring all the nodes hence time complexity is 2^n for the tree but 3^n for the first node
        2. Recursively calculate cost for each subtree (without creating tree node) using memoization by storing cost corresponding to house number and color. Complexity will be O(n) here as we calculate cost for each house and color only once but store in a dictionary which needs O(n) space

        Optimized approach: DP in O( n ) => Start from the second row /second last row and add to the current cost, the cost from previous row/last row for the possible options i.e. for second row cost to paint red = cost of red + min( cost to paint green or blue) for previous house. When values are added for the last house, take the min value and return.
        This can be done by either modifying the current array or maintaining two arrays (current value and previous) of size = number of colors. Both options will ave O(10 space complexity)
        
'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # Base case when costs is empty
        if costs == None or len(costs) == 0:
            return 0

        # initialize current and previous 1d array of size = 3 (no of colors)
        curr = [0 for _ in range(3)]
        # previous values will be the costs from 1st row in case of top down or last row in case of bottom up
        prev = [costs[0][i] for i in range(3)]
        
        # traverse the costs top dwn or bottom up
        for i in range(1,len(costs)):
            
            # current cost will be cost for painting current house with red plus min of painting prev house with blue/green
            curr[0] = costs[i][0] + min(prev[1], prev[2])
            # current cost will be cost for painting current house with green plus min of painting prev house with red/blue
            curr[1] = costs[i][1] + min(prev[0], prev[2])
            # current cost will be cost for painting current house with blue plus min of painting prev house with red/green
            curr[2] = costs[i][2] + min(prev[0], prev[1])
            
            # copy current values to previous array
            prev = [curr[i] for i in range(3)]
        
        # as prev will have current costs at the end of traversing return min of three
        return min(prev[0], prev[1], prev[2])