# Time Complexity : For last method - O(m*n), where m is the number of houses to be painted n is the number of possible colors.
# Space Complexity : For last method - O(1).
# Did this code successfully run on Leetcode : Yes

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
    # Method 1 - Recursion - TLE

    #     if len(costs)==0:
    #         return 0
        
    #     colorR=self.helper(costs,0,0,0)
    #     colorG=self.helper(costs,0,1,0)
    #     colorB=self.helper(costs,0,2,0)

    #     return min(colorR,colorG,colorB)
    

    # def helper(self,costs,i,color,mincost):
    #     #base
    #     if i==len(costs):
    #         return mincost
        

    #     if color==0:
    #         return min(self.helper(costs,i+1,1,mincost+costs[i][0]),self.helper(costs,i+1,2,mincost+costs[i][0])) #min(next row blue,next row green)
    #     elif color==1:
    #         return min(self.helper(costs,i+1,0,mincost+costs[i][1]),self.helper(costs,i+1,2,mincost+costs[i][1])) #min(next row red,next row green)
    #     elif color==2:
    #         return min(self.helper(costs,i+1,0,mincost+costs[i][2]),self.helper(costs,i+1,1,mincost+costs[i][2])) #min(next row red,next row green)

    #Method 2 - DP with 2D space

        # if len(costs)==0:
        #     return 0
        # n=len(costs)
        # dp=[[0 for _ in range(3)] for _ in range(n)]
        # dp[n-1][0]=costs[n-1][0]
        # dp[n-1][1]=costs[n-1][1]
        # dp[n-1][2]=costs[n-1][2]

        # for i in reversed(range(0,n-1)):      #it's n-2 to 0, cause I'm using reversed and range, it will be n-2+1=n-1
        #     dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
        #     dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
        #     dp[i][2]=costs[i][2]+min(dp[i+1][0],dp[i+1][1])
        
        # return min(dp[0])
    
    #Method 2 - DP with 1D space
        # if len(costs)==0:
        #     return 0
        # n=len(costs)
        # dp=[0 for _ in range(3)]
        # dp[0]=costs[n-1][0]
        # dp[1]=costs[n-1][1]
        # dp[2]=costs[n-1][2]
        # for i in reversed(range(0,n-1)):      #it's n-2 to 0, cause I'm using reversed and range, it will be n-2+1=n-1
        #     tempRed=dp[0]                       #Since dp[0], get overwritten in line 54, we can't use dp[0] in line 56.
        #     dp[0]=costs[i][0]+min(dp[1],dp[2])
        #     tempBlue=dp[1]                      #Since dp[1], get overwritten in line 56, we can't use dp[1] in line 57.
        #     dp[1]=costs[i][1]+min(tempRed,dp[2])
        #     dp[2]=costs[i][2]+min(tempRed,tempBlue)
        
        # return min(dp)
    
    #Method 3 - DP with 3 variables
       
        if len(costs)==0:
            return 0
        n=len(costs)
        CostR=costs[n-1][0]
        CostB=costs[n-1][1]
        CostG=costs[n-1][2]

        for i in reversed(range(0,n-1)):      #it's n-2 to 0, cause I'm using reversed and range, it will be n-2+1=n-1
            tempRed=CostR                       #Since tempRed, get overwritten in line 54, we can't use tempRed in line 56.
            CostR=costs[i][0]+min(CostB,CostG)
            tempBlue=CostB                     #Since tempBlue, get overwritten in line 56, we can't use tempBlue in line 57.
            CostB=costs[i][1]+min(tempRed,CostG)
            CostG=costs[i][2]+min(tempRed,tempBlue)
        
        return min(CostR,CostB,CostG)
        

