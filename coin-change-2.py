# Time Complexity : O(m*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = amount
        m = len(coins)
        dp = [0]*(n+1)
        dp[0] = 1

        for i in range(1, m+1):
            for j in range(n+1):
                if(j >= coins[i-1]):
                    dp[j] = dp[j] + dp[j-coins[i-1]]

        return dp[n]

sc = Solution()
amount = 5
coins = [1,2,5]
print(sc.change(amount, coins))