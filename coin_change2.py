// Time Complexity :o(mk)
// Space Complexity :o(mk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if(coins==None):
            return 0
        if(amount==0):
            return 1
        rows=(len(coins)+1)
        cols=amount+1
        dp=[[None for i in range(cols)]for j in range(rows)]
        for j in range(cols):
            dp[0][0]=1
            dp[0][j]=0
        for i in range(1,rows):
            for j in range(cols):
                if(coins[i-1] > j):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[rows-1][cols-1]
    
