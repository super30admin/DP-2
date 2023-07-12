#time: O(mn), m is amount and n is number of denominations
#space: O(m)
# issues faced: none
# did the code run successfully : yes
#Approach:
# bottom-up(tabulation) method to find number of ways for each amount with optimal space
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0 for _ in range(amount+1)]
        dp[0] = 1
        for coin in coins:
            for j in range(coin, amount+1):
                dp[j] += dp[j-coin]
        return dp[-1]