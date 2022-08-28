#Tc: O(m*n) m->colors, n-> no of houses
#Sc: O(m*n) m->colors, n-> no of houses
class Solution:
    def minCost(self, costs) -> int:
        
        # create a dp of size same as cost with None
        dp = [[None]*3 for i in range(len(costs))]
        # Copy the last costs as it is into dp's last row
        for j in range(3):
            dp[len(costs)-1][j] = costs[len(costs)-1][j]
        # From second last row of dp keep filling the summation of costs until you reach first row of dp
        for i in range(len(costs)-2,-1,-1):
            # Choosing 0 color
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2]) 
            # Choosing 1 color
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            # Choosing 2 color
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])
        # return the min of the first row of dp to get the min cost to paint all houses
        return min(dp[0])
        
obj = Solution()
print(obj.minCost([[17,2,17],[16,16,5],[14,3,19]]))