# Time complexity : O(m) --> m - number of houses
# Space complexity : O(m) --> m - number of houses
# Leetcode : Solved and submitted 
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        
        # return 0 if there are no houses to paint
        if len(costs) == 0:
            return 0
        
        # creating a dp matrix to store the minimum cost at each point
        dp = [[0 for _ in range(3)] for _ in range(n)]
        
        # Since we are doing the bottom up approach, we copy the values of the bottom row as it is in the dp matrix where we will update all the costs
        for i in range(3):
            dp[n-1][i] = costs[n-1][i]
        
        # we traverse from the last row to the top while updating the cost at each row
        for i in range(n-2,-1,-1):
            for j in range(3):
              
        # if we are taking the red color for the current house, then we add the cost of blue and green in the previous step and find the min of the two
                if j == 0: # case for red
                    dp[i][0] += min(costs[i][0] + dp[i+1][1], costs[i][0]+dp[i+1][2])
        # if we are taking the red color for the current house, then we add the cost of blue and green in the previous step and find the min of the two
                if j == 1: # case for blue
                    dp[i][1] += min(costs[i][1] + dp[i+1][0], costs[i][1] + dp[i+1][2])
        # if we are taking the red color for the current house, then we add the cost of blue and green in the previous step and find the min of the two
                if j == 2: # case for green
                    dp[i][2] += min(costs[i][2] + dp[i+1][0], costs[i][2] + dp[i+1][1])
              
        # At the very last, we have the total path of painting all the houses from each way, so we get the min out of all 3 possibilities
        return min(dp[0][0],min(dp[0][1],dp[0][2]))
