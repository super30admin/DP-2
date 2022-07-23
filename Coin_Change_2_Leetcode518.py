class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # DP saving space TC - O(n*amount) SC - O(amount)
        n = len(coins)
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for j in range(1, amount + 1):
                if j >= coin:
                    dp[j] = dp[j] + dp[j - coin]
        return dp[amount]

    '''
        # DP TC - O(n*amount) SC - O(n*amount)
        n = len(coins)
        dp = [[0]*(amount+1) for _ in range(n+1)]
        for i in range(n+1):
            dp[i][0] = 1

        for i in range(1,n+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                elif j >= coins[i-1]:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][amount]             
    '''

    '''
        # Recursion Time Limit exceeded
        # TC - much greater than O(2**n) because we can repeat the coinss
        # SC - O(min(coins))
        n = len(coins)
        return self.helper(coins,amount,n,0)

    def helper(self, coins, amount, n, ways):
        # base
        if n == 0 or amount < 0:
            return 0
        if amount == 0:
            return 1

        # logic
        # choose
        case1 = self.helper(coins,amount-coins[n-1], n, ways)

        # no choose
        case2 = self.helper(coins,amount, n-1, ways)

        return case1+case2
    '''



