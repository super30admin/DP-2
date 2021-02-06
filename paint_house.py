// Time Complexity : O(n*m)
// Space Complexity : O(n) where n is the no. of rows in costs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Is of the form Choose/Dont choose. Made use of DP and started from 
// 2nd row and carried forward the results to the last row. Finally the answer was the minimum of the last row. 

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if(costs==[]):
            return(0)
        dp=costs
        
        for i in range(1,len(dp)):
            
            dp[i][0] += min(dp[i-1][1], dp[i-1][2])
            
            dp[i][1] += min(dp[i-1][0], dp[i-1][2])
            
            dp[i][2] += min(dp[i-1][1], dp[i-1][0])
        
        return(min(dp[len(dp)-1]))
        