# Time Complexity : O(N*M) where N is amount and M is coins
# Space Complexity : O(N*M) where N is amount and m is coins
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Some..but it was just growing 
# pains learning DP again.


# Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        """
        Initial thoughts:
            - Couldn't think of a greedy solution for this... so DP
        Draw out table and find pattern similar to coinChange1
        Used brain power to draw out the table first and found the pattern.
            - if current index in matrix (dp[i][j]) is less than the current coin, just take value from 
            previous row.
            - else put current index in matrix (dp[i][j]) as the sum of the value above and the column - coinValue
        """
        if not coins and amount == 0:
            return 1
        
        #create table
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        
        #first col set to 1 for table
        for j in range(1, len(dp)):
            dp[j][0] = 1
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                
        result = dp[(len(dp)-1)][len(dp[0])-1]
        
        return result
