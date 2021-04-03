# Bottom up approach to compute the Number of ways to make the amount.
# Formula is dp[coinRow][amount] = dp(coinRow,amount - coins[coinRow]) + dp (coinRow-1,amount)
# Time complexity is O(MN) and Space complexity is O(MN), where M being the amount and N being the length of coins
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if(amount == 0):
            return 1
        if(len(coins) == 0):
            return 0
        def value(dp,i,j):
            if(0<= i < len(dp) and 0<= j < len(dp[0])):
                return dp[i][j]
            return 0
        
        dp = [[0]*(amount+1)]*len(coins)
        for i in range(len(coins)):
            dp[i][0] = 1
            for j in range(1,amount+1):
                dp[i][j] = value(dp,i,j-coins[i]) + value(dp,i-1,j)
        return dp[-1][-1]