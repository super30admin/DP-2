
from typing import List

"""

    Student : Shahreen Shahjahan Psyche

    Dynammic Programming:
        Time Complexity : O(N)
        Space Complexity : O(1)
    This solution successfully passed all the test cases in Leetcode


"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # edge case
        if costs is None or len(costs) == 0:
            return 0
        
        # Mutating the cost list itself. Taking the minimum value from the previous row and adding it with the current rows value
        # Thus we iterate through. 
        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
        
        # The min of the the last row will be our desired output. 
        min_cost = min(costs[len(costs)-1][:])
        
        return min_cost
                