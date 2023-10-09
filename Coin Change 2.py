#executed on LC : yes 518
#problems faced: NA, not quite sure I understnd how 1D array worked. but it worked!

#TC: O(m*n) , n is amount, m - no of coins
#SC: O(m*n) , n is amount, m - no of coins
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if coins is None:
            return 0
        m = len(coins)
        n = amount
        dp = [[0]*(n+1) for _ in range(m+1)]
        dp[0][0] = 1

        for j in range(1, m+1):
            dp[j][0]=1
        for j in range(1,n+1):
            for i in range(1,m+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        if dp[m][n] >= maxsize - 10: return -1
        return dp[m][n]

#Space optimzation
#TC: O(m*n) , n is amount, m - no of coins
#SC: O(n) , n is amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [0] * (amount + 1)
        dp[0] = 1

        for i in range(n - 1, -1, -1):
            for j in range(coins[i], amount + 1):
                dp[j] += dp[j - coins[i]]

        return dp[amount]
        