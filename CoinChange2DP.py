# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp =[[0]*(amount+1)]*(len(coins)+1)
        #first column is 1
        for i in range(1, len(dp)):
            dp[i][0] = 1 # or infinity
        
        for i in range(1, len(dp)):
            for j in range(1,len(dp[0])):
                if(j< coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = (dp[i-1][j] + dp[i][j-coins[i-1]])
                          
        
        return dp[len(dp)-1][len(dp[0])-1]