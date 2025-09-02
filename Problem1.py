"""
TC: O(N) {since there are only 3 color choices and we iterate through all the rows only once and save the repeated sub problems}
SC: O(N) {we use a dictionary to store the repeated sub problems, hence its O(n) space}

Approach:
For every house (out of the 3) on the first row, we start our solution. Then iteratively we check which of the given houses with
the next row without the same col gives us the minimum result, we do it until we reach the last row. At the end we get the min result that we wanted.

This problem ran successfully on Leetcode.
"""



from typing import (
    List,
)

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs: List[List[int]]) -> int:
        # write your code here
        cache = {}
        def helper(i, j):
            #base case out of bounds
            if i == len(costs):
                return 0
            if (i,j) in cache:
                return cache[(i,j)]
            #paint the house
            if j == 0:
                case1 = helper(i+1, 1)
                case2 = helper(i+1, 2)
            elif j == 1:
                case1 = helper(i+1, 0)
                case2 = helper(i+1, 2)
            else:
                case1 = helper(i+1, 0)
                case2 = helper(i+1, 1)

            cache[(i,j)] = costs[i][j] + min(case1, case2)

            return cache[(i,j)]


        res = float("inf")
        for i in range(3):
            res = min(res, helper(0,i))
        
        return res

