"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""


class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        #dp approach
        if len(costs)==0:
            return 0
        for i in range(len(costs)-2,-1,-1):
            costs[i][0]+=min(costs[i+1][1],costs[i+1][2])
            costs[i][1]+=min(costs[i+1][0],costs[i+1][2])
            costs[i][2]+=min(costs[i+1][0],costs[i+1][1])
        return min(costs[0][0],costs[0][1],costs[0][2])

#recursion approach
 #     if len(costs)==0:
    #         return 0
    #     case1 = self.helper(costs,0,0,0)
    #     case2 = self.helper(costs,0,1,0)
    #     case3 = self.helper(costs,0,2,0)
    #     return min(case1,case2,case3)
    # def helper(self,costs,row,color,minCost):
    #     #base case
    #     if(row == len(costs)):
    #         return minCost
    #     #case1
    #     if(color == 0):
    #         return min(self.helper(costs,row + 1,1,minCost + costs[row][0]),self.helper(costs,row + 1,2,minCost + costs[row][0]))
    #     if(color == 1):
    #         return min(self.helper(costs,row + 1,0,minCost + costs[row][1]),self.helper(costs,row + 1,2,minCost + costs[row][1]))
    #     if(color == 2):
    #         return min(self.helper(costs,row + 1,0,minCost + costs[row][2]),self.helper(costs,row + 1,1,minCost + costs[row][2]))