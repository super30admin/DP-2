# Time Complexity - O(n)
# Space Complexity - O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
            dp = [0] * 3
        
            dp[0] = costs[len(costs)-1][0]
            dp[1] = costs[len(costs)-1][1]
            dp[2] = costs[len(costs)-1][2]

            for i in range(len(costs)-2,-1,-1):

                tempR = dp[0]
                dp[0] = costs[i][0] + min(dp[1] , dp[2])
                tempB = dp[1]
                

                dp[1] = costs[i][1] + min(tempR , dp[2])
            
                dp[2] = costs[i][2] + min(tempR , tempB)

            return min(dp[0],dp[1],dp[2])


# 2d matrix approach

# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         matrix = [[0 for j in range(3)] for i in range(len(costs))]
        
#         matrix[len(costs)-1] = costs[len(costs)-1]
#         for i in range(len(costs)-2, -1, -1):
#             matrix[i][0] = costs[i][0] + min(matrix[i+1][1] , matrix[i+1][2])
#             matrix[i][1] = costs[i][1] + min(matrix[i+1][0] , matrix[i+1][2])
#             matrix[i][2] = costs[i][2] + min(matrix[i+1][1] , matrix[i+1][0])

#         return min(matrix[0][0],matrix[0][1],matrix[0][2])

            
        