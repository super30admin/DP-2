#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes( Ran it on LintCode)
#  Any problem you faced while coding this : After looking through discussion found that It has simple splution and was easy to understand 



class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def minCost(self, costs):
        # write your code here
        if len(costs) == 0:
            return 0
        
        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
        
        return min(costs[-1][0], costs[-1][1], costs[-1][2])