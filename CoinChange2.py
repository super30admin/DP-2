# TC: O(no of coins x amount)
# SC: O(no of coins x amount)
# LeetCode: Y(https://leetcode.com/problems/coin-change-2/)
# Approach: Convert a recursive repeating optimizing problem into bottom-up dp
#           The number of ways to make a coin this way is the sum of previous denominations for same amount and the result of new denomination for same amount

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        
        dp[0][0] = 1
        
        for current_coin in range(1,len(dp)):
            for current_amount in range(len(dp[current_coin])):
                # if current_coin value is more than current amount to be made
                if(current_amount < coins[current_coin - 1]):
                    dp[current_coin][current_amount] = dp[current_coin - 1][current_amount]
                # add no of ways to make the given amount without using previous denominations and using the current denomination
                else:
                    dp[current_coin][current_amount] = dp[current_coin - 1][current_amount] + dp[current_coin][current_amount - coins[current_coin - 1]]
        
        
        return dp[-1][-1]
