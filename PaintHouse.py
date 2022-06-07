class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        
        '''// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        if len(costs)==0:
            return 0
        
        n=len(costs)
        #start from the bottom
        for i in range(n-2,-1,-1):
            #if color 0 is selected, select min cost color from 1 and 2
            costs[i][0] += min(costs[i+1][1],costs[i+1][2])
            #if color 1 is selected, select min cost color from 0 and 2
            costs[i][1] += min(costs[i+1][0],costs[i+1][2])
            #if color 2 is selected, select min cost color from 1 and 0
            costs[i][2] += min(costs[i+1][0],costs[i+1][1])
        #return overall min
        return min(costs[0][0], min(costs[0][1],costs[0][2]))
