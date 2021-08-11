# TC = O(lenth of coins * amount)
# SC = O(lenth of coins * amount)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins and amount == 0:return 1
        if not coins and amount != 0: return 0
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]

        # Fill the 1st column with 1 i.e. there is just one way of not forming the amount 0
        # by not picking any coins. that constitutes as 1 way

        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]

