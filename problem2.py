'''https://leetcode.com/problems/coin-change-2/
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
Ex.
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

'''

# Time Complexity : O(N*M) where N is len(coins) and M = amount
# Space Complexity : O(N*M) where N is len(coins) and M = amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None or len(coins) == 0: return 0
        
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 1
        
        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        
        return dp[-1][-1]