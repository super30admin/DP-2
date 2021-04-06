class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0]*(amount+1)
        dp[0] = 1
        
        # For each coin
        for coin in coins:
            # For entire range
            for i in range(coin, amount+1):
                # Add the number of ways to form combinations without picking + with picking
                dp[i] = dp[i] + dp[i-coin]
        
        # Return result
        return dp[amount]       

### Complexity Analysis:

# Time Complexity: O(coins x amount) --> For loop runs over the entire range of amount for each coin
# Space Complexity: O(amount) --> 1D array of length = amount
