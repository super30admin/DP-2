# Time complexity is O(m*n) - iterating the 2d array
# Space complexity is O(m*n) - size of the 2d array
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m=len(coins)+1
        n=amount+1
        dp=[[0]*n for i in range(m)]
        dp[0][0]=1
        for j in range(1,n):
            dp[0][j]=0
        
        for i in range(1,m):
            for j in range(0,n):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[m-1][n-1]
                    
        
    
        # exponential solution
        
#         def helper(coins,idx,amount):
#             #base
#             if amount==0:
#                 return 1
#             if amount<0 or idx==len(coins):
#                 return 0
            
#             #logic
#             # 2 choices - choose and dont choose
#             case1=helper(coins,idx+1,amount)
#             case2=helper(coins,idx,amount-coins[idx])
            
#             return case1+case2
        
        
#         val=helper(coins,0,amount)
#         return val
        
        
        
        