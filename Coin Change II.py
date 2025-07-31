class Solution(object):
    def change(self, amount, coins):
        dp= [0]* (amount+1)     # dp[i] = number of ways to make amount i
        dp[0]=1                 # Base case: one way to make amount 0 (no coins)

        for coin in coins:
            for x in range(coin, amount+1): # Try building amounts from coin to target
                dp[x]+=dp[x-coin]           # Add ways to make (x - coin) since we can use this coin

        return dp [amount]