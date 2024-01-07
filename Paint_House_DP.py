"""
Time Complexity : O(3n) == O(n) where n is the total number of houses. 
Space Complexity : O(1) as we are not using any auxillary data structire
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
1. Greedy fails so we should try Exhaustive search. Exhuastive search shows that there are multiple repeating subproblems, hence we can use dp
"""


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0

        n = len(costs)
        print(n)
        for i in range(n-2, -1, -1):
            for j in range(0, 3):
                if j == 0:
                    costs[i][j] = costs[i][j] + \
                        min(costs[i+1][j+1], costs[i+1][j+2])
                elif j == 1:
                    costs[i][j] = costs[i][j] + \
                        min(costs[i+1][j-1], costs[i+1][j+1])
                else:
                    costs[i][j] = costs[i][j] + \
                        min(costs[i+1][j-1], costs[i+1][j-2])
        return min(costs[0][0], costs[0][1], costs[0][2])
