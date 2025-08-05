#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        """
        rows=len(costs)
        columns=3
        dp=list(costs)
        for i in range(rows-2,-1,-1):
            for j in range(0,columns):
                minval=float('inf')
                for k in range(0,columns):
                    if k!=j:
                      minval=min(minval,dp[i+1][k])  

                dp[i][j]=dp[i][j]+minval
        
        minval_ret=float('inf')
        for k in range(0,columns):
            minval_ret=min(minval_ret,dp[0][k])  
        return minval_ret
        """
        houses=len(costs) # number of houses
        cost_red=costs[houses-1][0]  # cost of painting the last house red
        cost_green=costs[houses-1][1] # cost of painting the last house green
        cost_blue=costs[houses-1][2] # cost of painting the last house blue

        for i in range(houses-2,-1,-1):
            temp_red=cost_red   # before changing the value store in temp variable
            temp_green=cost_green
            temp_blue=cost_blue

            cost_red=costs[i][0]+min(temp_green,temp_blue) # update red by choosing the min between green and blue
            cost_green=costs[i][1]+min(temp_red,temp_blue) # update green by choosing the min between red and blue
            cost_blue=costs[i][2]+min(temp_green,temp_red) # update blue by choosing the min between green and red
        
        return min(cost_red,cost_green,cost_blue) # return the min value
