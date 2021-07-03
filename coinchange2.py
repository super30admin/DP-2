#https://leetcode.com/problems/coin-change-2/
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if not coins:
            return 0
        dp = [[0]*(amount+1)]*(len(coins)+1)
        for i in range(0,len(coins)+1):
            dp[i][0]=1
        for i in range(1,amount+1):
            dp[0][i]=0
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]