'''
T.C: O(n * m)
n - total coins, m - amount
S.C: O(n * m)

Intuition: bottum-up, dp table - cols: range(amount) rows: range(coins)

'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not amount:
            return 1
        
        if not coins:
            return 0
        
        coins_len = len(coins)
        dp = [[0 for j in range(amount+1)] for i in range(coins_len)]
        
        for idx in range(coins_len):
            dp[idx][0] = 1
        
        for idx in range(coins_len):
            for jdx in range(1, amount+1):
                if jdx < coins[idx]:
                    dp[idx][jdx] = dp[idx - 1][jdx]
                else:
                    dp[idx][jdx] = dp[idx][jdx - coins[idx]] + dp[idx-1][jdx]
        # print(dp)           
        return dp[-1][-1]