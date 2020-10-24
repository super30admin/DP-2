"""
Time Complexity : O(m) whene m is numbr of houses
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This is a DP solution in case we can not manipulate the initial array. At every row, we have memoised
what can be the minimum value for red , blue and green from the previous value and hence can be used
to find minimum cost after all the rows have been iterated
"""


class Solution:
    def minCost(self, costs):
        # write your code here
        if not costs or costs == None:
            return 0
        m = len(costs)
        n = len(costs[0])
        cr, cb, cg = 0, 0, 0
        for i in range(0, m):
            cr, cb, cg = costs[i][0]+min(cb, cg), costs[i][1] + \
                min(cr, cg), costs[i][2]+min(cb, cr)
        return(min(cr, cb, cg))


"""
This is a DP solution in case we can manipulate the initial array
"""


class Solution:
    def minCost(self, costs):
        # write your code here
        if not costs or costs == None:
            return 0
        m = len(costs)
        n = len(costs[0])
        for i in range(1, m):
            for j in range(n):
                costs[i][j] += min(costs[i-1][:j]+costs[i-1][j+1:])
        return(min(costs[-1]))


"""
This is the recursive code as of now which I wrote, will be modifying it to DP and submitting again
once I understand how DP can be handled here. Right now, it gives time limit exceeded. Thanks
"""


class Solution:
    def minCost(self, costs):
        # write your code here
        if not costs or costs == None:
            return 0
        case1 = self.helper(costs, 1, 0, costs[0][0])
        case2 = self.helper(costs, 1, 1, costs[0][1])
        case3 = self.helper(costs, 1, 2, costs[0][2])
        return min(case1, case2, case3)

    def helper(self, costs, row, color, mincost):
        if row == len(costs):
            return mincost
        if color == 0:
            return min(self.helper(costs, row+1, 1, mincost+costs[row][1]), self.helper(costs, row+1, 2, mincost+costs[row][2]))
        if color == 1:
            return min(self.helper(costs, row+1, 0, mincost+costs[row][0]), self.helper(costs, row+1, 2, mincost+costs[row][2]))
        if color == 2:
            return min(self.helper(costs, row+1, 1, mincost+costs[row][1]), self.helper(costs, row+1, 0, mincost+costs[row][0]))
