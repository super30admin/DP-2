class Solution:
#     def paint(self, n, color, costs, memo):
        
#         if (n, color) in memo:
#             return memo[(n,color)]
            
        
#         total_cost = costs[n][color]
        
#         if n == len(costs) - 1:
#             pass
        
#         elif color == 0:
#             total_cost += min(self.paint(n+1, 1, costs,memo), self.paint(n+1,2,costs,memo))
            
#         elif color == 1:
#             total_cost += min(self.paint(n+1, 0, costs,memo), self.paint(n+1,2,costs,memo))
            
#         else:
#             total_cost += min(self.paint(n+1, 0, costs,memo), self.paint(n+1,1,costs,memo))

            # memo[(n, color)] = total_cost
            # return total_cost
            

#         def minCost(self, costs: List[List[int]]) -> int:

#             if costs == []:
#                 return 0

#             memo = {}

#             return min(self.paint(0,0,costs, memo), self.paint(0,1,costs, memo), self.paint(0,2, costs, memo))
            
            
    def minCost(self, costs):
        if not costs:
            return 0

        # Initialize the DP table with the costs of the first house
        dp = costs[0]
        
        

        # Iterate through each house starting from the second one
        for n in range(1, len(costs)):
            # Current costs for each color
            current_red = costs[n][0] + min(dp[1], dp[2])
            current_blue = costs[n][1] + min(dp[0], dp[2])
            current_green = costs[n][2] + min(dp[0], dp[1])

            # Update the DP table for the current house
            dp = [current_red, current_blue, current_green]

        # The minimum cost will be the minimum of the costs for the last house
        
        print(dp)
        return min(dp)
            

        
        

        
