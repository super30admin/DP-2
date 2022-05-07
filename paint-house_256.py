#TimeComplexity: O(N) as colours are constant so just number of houses
#SpaceComplexity: O(1) (3 variables)
#It successfully runs on leetcode
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        r=costs[-1][0]
        b=costs[-1][1]
        g=costs[-1][2]
        for i in reversed(range(len(costs)-1)):
                tempr, tempb= r,b
                r =  costs[i][0] + min(b,g)
                b =  costs[i][1] + min(tempr,g)
                g =  costs[i][2] + min(tempr, tempb)
                
        return min(r,g,b)


#DP using 2d Matric
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:    
#         dp=costs
#         n=len(dp)
#         print(dp)
#         mini=99999
#         for i in reversed(range(n-1)):
#             for j in range(len(dp[0])):
#                 if j==0:
#                     dp[i][j]= dp[i][j]+ min(dp[i+1][1],dp[i+1][2])
#                 if j==1:
#                     dp[i][j]= dp[i][j]+ min(dp[i+1][0],dp[i+1][2])
#                 if j==2:
#                     dp[i][j]= dp[i][j]+ min(dp[i+1][1],dp[i+1][0])
#         for i in range(len(dp[0])):
#             mini = min(mini, dp[0][i])
#         return mini