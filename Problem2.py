#time complexity : 0(n)
#space complexity : 0(n)

class Solution(object):
    def change(self, amount, coins):
        
        if amount ==0:
            return 0
        
        dp = [0]*(amount+1)
        
        dp[0] = 0
        for index in range(amount + 1):
            for j in range(len(coins)):
                if coins[j] <= index:
                    dp[index] = dp[index-1] + 1 + dp[index - coins[j]]
        
        return dp[amount]
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        