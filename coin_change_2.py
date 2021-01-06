# Time Complexity : O(m*n) where m is the amount given in question
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since the explanation from class was clear.


# Your code here along with comments explaining your approach
# Dynamic Programming approach from class, where we use dp matrix to take solution
# from the sub problems and use to solve bigger problems

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        dp[0][0] = 1
        length_coins = len(coins)
        for i in range(1,length_coins+1):
            for j in range(amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
        
        return dp[length_coins][amount]