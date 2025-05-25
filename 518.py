'''
dp:
space - O(n*m)
time - O(m*n)
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # ways = self.coinrecursive(coins, 0, amount)
        ways = self.coindp(coins,amount)
        return ways

    def coindp(self,coins, amount):
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]
        '''
          0 1 2 3 4 5
        0 1 0 0 0 0 0 <- no. of ways to make the amount using 0 coin
        1 1 1 1 1 1 1
        2 1 1 2 2 3 3
        5 1 1 2 2 3 4
        '''
        for j in range(amount+1):
            dp[0][j] = 0
        dp[0][0] = 1

        for i in range(1, len(coins)+1):
            for j in range(amount+1):
                denomination = coins[i-1]
                amount = j
                if denomination > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-denomination]
        
        return dp[-1][-1]

    def coinrecursive(self, coins, idx, amount):
        count = 0
        if amount == 0:
            return 1
        if amount < 0:
            return 0
        if idx == len(coins):
            return 0

        choose = self.coinrecursive(coins, idx, amount-coins[idx])
        nochoose = self.coinrecursive(coins, idx+1, amount)
        return choose + nochoose

