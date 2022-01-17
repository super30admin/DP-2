class Solution:
    def change(self,amount:int,coins:List[int]) -> int:
        dp = [0] * (amount+1)
        dp[0] = 1

        for i in range(len(coins)-1,-1,-1):
            nextDP = [0] * (amount + 1)
            nextDP[0] = 1

            for a in range(1,amount+1):
                nextDP[a] = dp[a]
                if a - coins[i] >= 0:
                    nextDP[a] += nextDP[a - coins[i]]
            dp = nextDP
        return dp[amount]