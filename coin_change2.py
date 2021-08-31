# // Time Complexity : O(n*amount) where n: number of coins
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : how to design the table. (cols and the cell values)

# // Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        dp[0][0] = 1
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]