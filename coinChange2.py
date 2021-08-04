#Leetcode Problem 518
class Solution:
    def change(self, amount, coins):
        dp=[[0]*(amount+1)]*(len(coins)+1)
        
        for i in range(len(dp[0])):
            dp[0][i]=0
        for i in range(len(dp)):
            dp[i][0]=1
        print(dp)
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[-1][-1]

#TC: O(m*n)
#TC: O(m*n)