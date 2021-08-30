# Time Complexity : O(n*m)
# Space Complexity : 0(n*m)
# Is this problem on the leetcode: Yes
# Approach to solve this problem:

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount+1)                     # Initializing the dp array equal to amount+1
        dp[0] = 1                               # Edge case
        for c in coins:
            for j in range(c, amount+1):
                dp[j] += dp[j-c]                # We add the value by subtracting the denominations 
        return dp[amount]
    

        