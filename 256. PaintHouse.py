# TC in Dp:o(m*n)
# SC in Dp:(n)
# executed on leetcode
# Recurssion
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        
        #color Red = 1, green =2 blule =3
        def helper(costs,color,index,count):
            # base
            if index==len(costs):
                return count
            # we are at R
            if color==0:
                return min(helper(costs,1,index+1,count+costs[index][0]), helper(costs,2,index+1,count+costs[index][0]))
            # we are at G
            if color==1:
                return min(helper(costs,0,index+1,count+costs[index][1]), helper(costs,2,index+1,count+costs[index][1]))
            # we are at B
            if color==2:
                return min(helper(costs,0,index+1,count+costs[index][2]), helper(costs,1,index+1,count+costs[index][2]))
        R = helper(costs,0,0,0)
        G = helper(costs,1,0,0)
        B = helper(costs,2,0,0)
        return min(R,G,B)        
    
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        import math
        if len(costs)==0:
            return 0
        m = len(costs)
        n = len(costs[0])
        dp = [[0]*n for i in range(m)]
        i=0
        j=0
        ans = math.inf
        while i < m and j<n:
            if i == m-1:
                dp[i][j]=costs[i][j]
                j+=1  
            else:
                i+=1
        print(dp)
        print(m)
        for j in reversed(range(m-1)):
            print(j)
            dp[j][0]=costs[j][0]+min(dp[j+1][1],dp[j+1][2])
            dp[j][1]=costs[j][1]+min(dp[j+1][0],dp[j+1][2])
            dp[j][2]=costs[j][2]+min(dp[j+1][0],dp[j+1][1])
        print(dp) 
        for k in range(n):
            print(k)
            ans=min(dp[0][k],ans)
        return ans
        
            
    
        
        
        
        
        