"""
Approach

1. To find the total number of ways to reach the amount,can start with finding the total no of ways to reach the amount 0, 1, 2 ... till the target when we only have coin 0.
2. we can do the above stem when we have coin 0 and coins[0]
3. we create a Dp matrix with row header as coin denomination and column header as the target sum of 0,1,2.. till the target.
4. we calculate  each cell of the dp matrix as the no of ways we can reach the target sum by choosing the coin or not choosing the coin

"""


# Time Complexity : O(n*T) where n is the number of coins and T is the target
# Space Complexity : O(n*T) where n is the number of coins and T is the target
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows,columns = len(coins)+1, amount+1
        dp = [[None for j in range(columns)] for i in range(rows) ]
        
        for i in range(rows):
            dp[i][0]= 1
        for j in range(1,columns,1):
            dp[0][j]= 0
        for i in range(1, rows,1):
            for j in range(1,columns,1):
                if (j<coins[i-1]):
                    dp[i][j]  = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]