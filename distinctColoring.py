# #User function Template for python3
# Time Complexity O(3*N)
# Space Complexity O(3*N)
# Approach:If you draw and look at the tree you can see there are multiple repeated sub problems which acan computed once .This is DP so try greedy ->exaustive(recusrion in most cases)->optimize 
# that exaustive
# Exaustive:
#   For every path we check min and return it and for each house we take all 3 colors into considerations
# DP: 
# Start from last house why?(we can directly choose min cost color and that does not impact future iteration)This is bottom UP (looking form bottom to UP) at N-1 house for each we take each color 
# and get min of N houses other colours  and this process continues.return min at last for 1st row



# https://www.geeksforgeeks.org/problems/distinct-coloring--170645/1

class Solution:
    def distinctColoring (self, N, r, g, b):
        # code here 
        col_costs=[r,g,b]
        dp = [[0 for _ in range(N)] for _ in range(3)]
        
        # Base case: Last house
        dp[0][N-1] = r[N-1]
        dp[1][N-1] = g[N-1]
        dp[2][N-1] = b[N-1]
        for cost in range(N-2,-1,-1):
            for col in range(3):
                if col==0:
                    dp[col][cost]=col_costs[col][cost]+min(dp[1][cost+1],dp[2][cost+1])
                if col==1:
                    dp[col][cost]=col_costs[col][cost]+min(dp[0][cost+1],dp[2][cost+1])
                if col==2:
                    dp[col][cost]=col_costs[col][cost]+min(dp[1][cost+1],dp[0][cost+1])
        return min(dp[0][0],dp[1][0],dp[2][0])




#User function Template for python3

class Solution:
    def distinctColoring (self, N, r, g, b):
        # code here 
        colors=[r,g,b]
        def helper(N,colors,idx,color_idx):
            #base
            if idx==N:return 0
            
            
            #logic
            if color_idx==0:
                 a=helper(N,colors,idx+1,1)
                 b=helper(N,colors,idx+1,2)
                 return colors[0][idx]+min(a,b)
            if color_idx==1:
                 a=helper(N,colors,idx+1,0)
                 b=helper(N,colors,idx+1,2)
                 return colors[1][idx]+min(a,b)
            if color_idx==2:
                 a=helper(N,colors,idx+1,1)
                 b=helper(N,colors,idx+1,0)
                 return colors[2][idx]+min(a,b)
        
        return min (helper(N,colors,0,0),helper(N,colors,0,1) ,helper(N,colors,0,2) )      
         
