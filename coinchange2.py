class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        '''
        TC : O(n*m) -- O(amount * number of coins)
        SC : O(n) -- O(amount)
        
        Approach:
            base case : when amount is 0 possible way to make 0 is 1 "no coins"
            dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]] 

           0  1  2  3  4  5 
        1  1  1  1  1  1  1
        2  1  1  2  2  3  3
        5  1  1  2  2  3  4
        
        '''
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for i in range(coin,amount + 1):
                dp[i] += dp[i -coin]
        return dp[amount]
