#-------------Solution 1 : 2D Matrix--------
''' Time Complexity : O(m*n)
    Space Complexity : O(m*n)

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''    

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for _ in range(amount+1)] for _ in range(n+1)]
        dp[0][0] = 1
        for i in range(1,n+1):
            for j in range(amount+1):
                coin = coins[i-1]
                if coin > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin]
        return dp[n][amount]


#-------------Solution 2 : 1D Array--------
''' Time Complexity : O(m*n)
    Space Complexity : O(m)

    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''    

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [0 for _ in range(amount+1)]
        dp[0] = 1
        for i in range(0,n):
            for j in range(amount+1):
                coin = coins[i]
                if coin <= j:
                    dp[j] = dp[j] + dp[j-coin]
        return dp[amount]
