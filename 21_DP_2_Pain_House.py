#Time Complexity : O(N) where N is the number of houses 
#Space Complexity : O(1) No space is using because we are replacing in 2d array only 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        
        if len(costs)==0: 
            return 0
        
        for i in range (1,len(costs)): 
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][0],costs[i-1][1])
            
        return min(min(costs[len(costs)-1][0],costs[len(costs)-1][1]),costs[len(costs)-1][2])    