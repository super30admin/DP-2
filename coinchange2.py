# // Time Complexity :O(len(coins) * amount)
# // Space Complexity :O(amount)
# // Did this code successfully run on Leetcode :yes 
# // Any problem you faced while coding this :nO
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount+1)
        dp[0] =1

        for i in range(len(coins)-1,-1,-1):
            for j in range(1,amount+1):
                if j - coins[i] >=0:
                    dp[j] += dp[j-coins[i]]
                
            print(dp)
        return dp[amount] 