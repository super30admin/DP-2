# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Find the sub problem
# Formulate the dp matrix
# return the last element

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for i in range(len(dp)):
            dp[i][0] = 1
            
        for i in range(1,len(dp)):
            for j in range(0,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]
            