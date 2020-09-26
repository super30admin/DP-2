class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0]*(amount+1)
        dp[0]=1
        for coin in coins:
            for amt in range(amount+1):
                if amt>=coin:
                    print(amt-coin)
                    dp[amt] = dp[amt] + dp[amt-coin]
        return (dp[len(dp)-1])
        