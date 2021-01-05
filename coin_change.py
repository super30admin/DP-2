# Time Complexity: O(num_coins * amount)
# Space Complexity: O(amount)
# Accepted on leetcode
# Got confused while trying to code out the 2D array approach before 1D. Found 1D simpler to understand.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        # initialize arrays with zeros of the length amount+1 (going from 0 to amount)
        dp = [0] * (amount + 1)
        # num of ways to choose zero amount is always 1
        dp[0] = 1
        
        # for each coin denomination
        for coin in coins:
            # update the value to -> (value at previous row at current col) + (value at same row and j-coin column)
            for j in range(coin, amount+1):
                dp[j] += dp[j-coin]
        
        # return amount at last column as that contains the number of ways corresponding to the amount
        return dp[amount]