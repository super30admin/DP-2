 
    # 256. Paint House

    # Time Complexity : O(m*n)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

# BRUTE FORCE 
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
   
        def dp(costs, color, i, minSum, s=0):
           
            print(s)
            if i == len(costs):
                return minSum
            if color == 0:
                return min(dp(costs, 1, i+1, minSum+costs[i][0]), 
                           dp(costs, 2, i+1, minSum+costs[i][0]))
            elif color == 1:
                return min(dp(costs, 0, i+1, minSum+costs[i][1]), 
                           dp(costs, 2, i+1, minSum+costs[i][1]))
            else:
                return min(dp(costs, 0, i+1, minSum+costs[i][2]), 
                           dp(costs, 1, i+1, minSum+costs[i][2]))
        
        dpR = dp(costs, 0, 0, 0)

        dpG = dp(costs, 1, 0, 0) 

        dpB = dp(costs, 2, 0, 0)
       
        return min(dpR, min(dpG, dpB))



    # Time Complexity : O(n)
    # Space Complexity : O(m) m= number of colors
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        dp = [0,0,0]
        
        for i in range(len(costs)):
            dpR = costs[i][0] + min(dp[1], dp[2])
            dpG = costs[i][1] + min(dp[0], dp[2])
            dpB = costs[i][2] + min(dp[1], dp[0])
            
            # store the last min in an array
            dp = [dpR, dpG, dpB]
            
        return min(dp)
        
                
            