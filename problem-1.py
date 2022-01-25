# Leetcode Execution: YES
# Time Complexity: O(n)
# Space Complexity:O(n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp=[[0,0,0] for x in range(len(costs)) ]
        dp[len(costs)-1]=costs[len(costs)-1]
        # print(dp)
        # creating new n *3 array and copying last row from costs to new dp array
        # loop and calculate each value taking from costs and addign the min of the options it have from the next row
        for i in range(len(dp)-2,-1,-1):
            dp[i][0]=costs[i][0]+min(dp[i+1][1], dp[i+1][2])
            dp[i][1]=costs[i][1]+min(dp[i+1][0], dp[i+1][2])
            dp[i][2]=costs[i][2]+min(dp[i+1][1], dp[i+1][0])
            
        # return the min of all the three values of the top row of dp
        # we return from top row because we followed the bottom up approach and the final answer is in the top row of dp array
        
        return min(dp[0][0],min(dp[0][1], dp[0][2]))
        
        
        
        
        
        
        
        
        
        
        
        
# Leetcode Execution: YES
# Time Complexity: O(n)
# Space Complexity:O(1)
        # in place by mutating given array
#         for i in range(len(costs)-2, -1, -1):
#             print(i)
#             costs[i][0]+=min(costs[i+1][1],costs[i+1][2])
#             costs[i][1]+=min(costs[i+1][0],costs[i+1][2])
#             costs[i][2]+=min(costs[i+1][0],costs[i+1][1])
                
                
#         return min(costs[0][0],min(costs[0][1], costs[0][2]))
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        # exhaustive approach
        # case1=self.helper(costs,0,0)
        # case2=self.helper(costs,0,1)
        # case3=self.helper(costs,0,2)
        # print(self.mapp)
        # return min(case1, min(case2,case3))
        
#     def helper(self, costs, row, color):
#         # //base case
#         if row==len(costs):
#             return 0
        
        
#         if row<len(costs)-1 and (f"{costs[row][color]},{costs[row+1][color-1]},{costs[row+1][color-2]}" in self.mapp) :
#             return self.mapp[f"{costs[row][color]},{costs[row+1][color-1]},{costs[row+1][color-2]}"]
        
#         if color==0:
#             m= min(
#             self.helper(costs,row+1,1)+costs[row][0],
#             self.helper(costs,row+1,2)+costs[row][0]
            
#             )
#             if row<len(costs)-1:
#                 self.mapp[f"{costs[row][color]},{costs[row+1][color-1]},{costs[row+1][color-2]}"]=m
#             return m
            
#         elif color==1:
#             m= min(
#             self.helper(costs,row+1,0)+costs[row][1],
#             self.helper(costs,row+1,2)+costs[row][1]
            
#             )
#             if row<len(costs)-1:
#                 self.mapp[f"{costs[row][color]},{costs[row+1][color-1]},{costs[row+1][color-2]}"]=m
#             return m
#         elif color==2:
#             m= min(
#             self.helper(costs,row+1,1)+costs[row][2],
#             self.helper(costs,row+1,0)+costs[row][2]
            
#             )
#             if row<len(costs)-1:
#                 self.mapp[f"{costs[row][color]},{costs[row+1][color-1]},{costs[row+1][color-2]}"]=m
#             return m
            